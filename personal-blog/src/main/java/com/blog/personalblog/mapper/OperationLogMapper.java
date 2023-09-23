package com.blog.personalblog.mapper;

import com.blog.personalblog.entity.OperationLog;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liweiliang
 * @create 2023-05-31 20:14:42
 * @description
 */
@Repository
public interface OperationLogMapper {

    /**
     * 创建操作日志
     * @param operationLog
     * @return
     */
    int createOperationLog(OperationLog operationLog);

    /**
     * 分类列表（分页）
     * @return
     */
    List<OperationLog> getOperationLogPage();

}