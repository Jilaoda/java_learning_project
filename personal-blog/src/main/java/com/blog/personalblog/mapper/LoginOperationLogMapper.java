package com.blog.personalblog.mapper;

import com.blog.personalblog.entity.LoginOperationLog;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liweiliang
 * @create 2023-05-31 20:30:30
 * @description
 */
@Repository
public interface LoginOperationLogMapper {

    /**
     * 创建登录日志
     * @param loginOperationLog
     * @return
     */
    int createLoginOperationLog(LoginOperationLog loginOperationLog);

    /**
     * 分类列表（分页）
     * @return
     */
    List<LoginOperationLog> getLoginOperationLogPage();
}