package com.blog.personalblog.service;

import com.blog.personalblog.config.page.PageRequest;
import com.blog.personalblog.entity.LoginOperationLog;

import java.util.List;

/**
 * @author liweiliang
 * @create 2023-05-31 20:29:51
 * @description
 */
public interface LoginOperationLogService {

    /**
     * 添加登录日志
     *
     * @param loginOperationLog
     * @return
     */
    void saveOperationLog(LoginOperationLog loginOperationLog);

    /**
     * 登录日志列表（分页）
     *
     * @param pageRequest
     * @return
     */
    List<LoginOperationLog> getLoginOperationLogPage(PageRequest pageRequest);

}
