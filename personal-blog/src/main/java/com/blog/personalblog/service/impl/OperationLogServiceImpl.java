package com.blog.personalblog.service.impl;

import com.blog.personalblog.config.page.PageRequest;
import com.blog.personalblog.entity.OperationLog;
import com.blog.personalblog.mapper.OperationLogMapper;
import com.blog.personalblog.service.OperationLogService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liweiliang
 * @create 2023-05-31 20:14:25
 * @description
 */
@Service
public class OperationLogServiceImpl implements OperationLogService {

    @Resource
    OperationLogMapper operationLogMapper;

    @Override
    public void saveOperationLog(OperationLog operationLog) {
        operationLogMapper.createOperationLog(operationLog);
    }

    @Override
    public List<OperationLog> getOperationLogPage(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        List<OperationLog> operationLogList = operationLogMapper.getOperationLogPage();
        return operationLogList;
    }

}