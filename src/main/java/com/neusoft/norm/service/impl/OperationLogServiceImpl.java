package com.neusoft.norm.service.impl;

import com.neusoft.norm.domain.OperationLog;
import com.neusoft.norm.domain.vo.SearchParams;
import com.neusoft.norm.mapper.OperationLogMapper;
import com.neusoft.norm.service.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 作者: 张明楠 创建于 16/12/19.
 */
@Service
public class OperationLogServiceImpl implements OperationLogService {

    @Autowired
    OperationLogMapper operationLogMapper;

    @Override
    public List<OperationLog> findAll(SearchParams searchParams) {
        return operationLogMapper.findAll(searchParams);
    }
}
