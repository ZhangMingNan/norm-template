package com.neusoft.norm.service;

import com.neusoft.norm.domain.OperationLog;
import com.neusoft.norm.domain.vo.SearchParams;

import java.util.List;

/**
 * 作者: 张明楠 创建于 16/12/19.
 */
public interface OperationLogService {
    public List<OperationLog> findAll(SearchParams searchParams);
}
