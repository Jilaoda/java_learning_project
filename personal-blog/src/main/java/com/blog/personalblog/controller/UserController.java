package com.blog.personalblog.controller;

import cn.hutool.core.util.StrUtil;
import com.blog.personalblog.annotation.OperationLogSys;
import com.blog.personalblog.annotation.OperationType;
import com.blog.personalblog.entity.ErrorCode;
import com.blog.personalblog.entity.LoginModel;
import com.blog.personalblog.entity.LoginOperationLog;
import com.blog.personalblog.entity.User;
import com.blog.personalblog.service.LoginOperationLogService;
import com.blog.personalblog.service.UserService;
import com.blog.personalblog.util.*;
import eu.bitwalker.useragentutils.UserAgent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.map.HashedMap;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author liweiliang
 * @create 2023-05-09 21:40:10
 * @description 基于Spring MVC框架的控制器，用于处理与用户相关的HTTP请求,
 *              并通过调用UserService中的方法来完成相应的用户操作功能。
 */
@Api(tags = "用户控制")
@RestController //指示其为一个RESTful风格的Web服务
@RequestMapping("/user")   //@RequestMapping注解将请求映射到对应的处理方法上
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserService userService;
    @Resource
    private LoginOperationLogService loginOperationLogService;


    /**
     * @details: 用户列表
     * @date: 2023/5/11
     * @Param: []
     * @return: com.blog.personalblog.util.JsonResult<java.lang.Object>
     */
    @ApiOperation(value = "用户列表")
    @PostMapping("/list")
    public JsonResult<Object> list() {
        List<User> userList = userService.findAll();
        return JsonResult.success(userList);
    }

    /**
     * @details: 创建用户
     * @date: 2023/5/11
     * @Param: [user]
     * @return: com.blog.personalblog.util.JsonResult<java.lang.Object>
     */
    @ApiOperation(value = "添加用户")
    @PostMapping("/create")
    @OperationLogSys(desc = "添加用户", operationType = OperationType.INSERT)
    public JsonResult<Object> userCreate(@RequestBody @Valid User user) {
        if (StrUtil.isEmpty(user.getPassWord())) {
            return JsonResult.error("密码为空，请填写密码！");
        }
        //密码加密存储
        user.setPassWord(MD5Util.MD5(user.getPassWord()));
        //判断手机号，这里用hutool工具类也可以
        if (!PhoneUtil.checkMobile(user.getPhone())) {
            return JsonResult.error("手机号码格式错误！");
        }
        userService.createUser(user);
        return JsonResult.success();
    }

    /**
     * @details: 修改用户
     *       - @RequestBody 注解的目的是将 HTTP 请求体中的数据绑定到方法参数上
     *       - @Valid 注解的目的是进行数据校验，确保 User 对象中的字段满足预设的要求
     * @date: 2023/5/11
     * @Param: [user]
     * @return: com.blog.personalblog.util.JsonResult<java.lang.Object>
     */
    @ApiOperation(value = "修改用户")
    @PostMapping("/update")
    @OperationLogSys(desc = "修改用户", operationType = OperationType.UPDATE)
    public JsonResult<Object> userUpdate(@RequestBody @Valid User user) {
        if (StrUtil.isEmpty(user.getPassWord())) {
            return JsonResult.error("密码为空，请填写密码！");
        }
        //密码加密存储
        user.setPassWord(MD5Util.MD5(user.getPassWord()));
        //判断手机号，这里用hutool工具类也可以
        if (!PhoneUtil.checkMobile(user.getPhone())) {
            return JsonResult.error("手机号码格式错误！");
        }
        userService.updateUser(user);
        return JsonResult.success();
    }

    /**
     * @details: 删除用户   @PathVariable注解用于从URI中提取参数值
     * @date: 2023/5/11
     * @Param: [id]
     * @return: com.blog.personalblog.util.JsonResult<java.lang.Object>
     */
    @ApiOperation(value = "删除用户")
    @PostMapping("/delete")
    @OperationLogSys(desc = "删除用户", operationType = OperationType.DELETE)
    public JsonResult<Object> userDelete(@RequestParam(value = "id") int id) {
        userService.deleteUser(id);
        return JsonResult.success();
    }

    /**
     * 登录
     * @param loginModel
     * @return
     */
    @ApiOperation(value = "登录")
    @PostMapping("/login")
    @OperationLogSys(desc = "登录", operationType = OperationType.LOGIN)
    public JsonResult<Object> login(@RequestBody LoginModel loginModel){
        logger.info("{} 在请求登录！ ", loginModel.getUsername());
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginModel.getUsername(), loginModel.getPassword(), false);
        try {
            subject.login(token);
            Map<String, Object> ret = new HashedMap();
            ret.put("token", subject.getSession().getId());
            logger.info("{} login success", loginModel.getUsername());
            getLoginInfoLog(loginModel, 0);
            //修改上个登录的时间
            User user = userService.getUserByUserName(loginModel.getUsername());
            userService.updateLoginTime(user.getId());
            return JsonResult.success(ret);
        } catch (IncorrectCredentialsException e) {
            logger.info("login fail {}", e.getMessage());
            return JsonResult.error(ErrorCode.NOT_LOGIN);
        } catch (LockedAccountException e) {
            logger.info("login fail {}", e.getMessage());
            return JsonResult.error(ErrorCode.ERROR_CODE);
        } catch (AuthenticationException e) {
            logger.info("login fail {}", e.getMessage());
            return JsonResult.error(ErrorCode.USER_NOT_EXIST);
        } catch (Exception e) {
            e.printStackTrace();
            getLoginInfoLog(loginModel, 1);
            logger.info("login fail {}", e.getMessage());
            return JsonResult.error(ErrorCode.ERROR_CODE);
        }
    }

    /**
     * 登录info信息
     * @return
     */
    @GetMapping("/info")
    public JsonResult<Object> info(){
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        User user = userService.getUserByUserName(username);
        Map<String, Object> ret = new HashMap<>(3);
        ret.put("roles", "[admin]");
        ret.put("name", user.getUserName());
        ret.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return JsonResult.success(ret);
    }


    @PostMapping("/logout")
    public JsonResult<Object> logout(){
        Subject subject =SecurityUtils.getSubject();
        subject.logout();
        return JsonResult.success("成功登出");
    }

    @RequestMapping("/unauth")
    public JsonResult<Object> unauth(){
        return JsonResult.error(ErrorCode.NOT_LOGIN);
    }

    /**
     * 获取登录日志
     */
    public void getLoginInfoLog(LoginModel loginModel, Integer status) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = (HttpServletRequest) Objects.requireNonNull(requestAttributes).resolveReference(RequestAttributes.REFERENCE_REQUEST);
        //解析agent字符串
        UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));

        //登录账号
        LoginOperationLog loginOperationLog = new LoginOperationLog();
        loginOperationLog.setLoginName(loginModel.getUsername());

        //登录IP地址
        String ipAddr = IpUtil.getIpAddr(request);
        loginOperationLog.setIpAddress(ipAddr);
        //登录地点
        String ipInfo = IpUtil.getIpInfo(ipAddr);
        loginOperationLog.setLoginLocation(ipInfo);
        //浏览器类型
        String browser = userAgent.getBrowser().getName();
        loginOperationLog.setBrowserType(browser);
        //操作系统
        String os = userAgent.getOperatingSystem().getName();
        loginOperationLog.setOs(os);
        //登录状态
        loginOperationLog.setLoginStatus(status);
        loginOperationLogService.saveOperationLog(loginOperationLog);
    }
}
