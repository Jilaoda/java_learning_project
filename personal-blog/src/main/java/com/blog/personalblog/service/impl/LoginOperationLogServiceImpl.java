package com.blog.personalblog.service.impl;

import com.blog.personalblog.config.page.PageRequest;
import com.blog.personalblog.entity.LoginOperationLog;
import com.blog.personalblog.mapper.LoginOperationLogMapper;
import com.blog.personalblog.service.LoginOperationLogService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liweiliang
 * @create 2023-05-31 20:30:04
 * @description
 */
@Service
public class LoginOperationLogServiceImpl implements LoginOperationLogService {

    @Resource
    private LoginOperationLogMapper loginOperationLogMapper;

    @Override
    public void saveOperationLog(LoginOperationLog loginOperationLog) {
        loginOperationLogMapper.createLoginOperationLog(loginOperationLog);
    }

    @Override
    public List<LoginOperationLog> getLoginOperationLogPage(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        List<LoginOperationLog> loginOperationLogList = loginOperationLogMapper.getLoginOperationLogPage();
        return loginOperationLogList;
    }

}
