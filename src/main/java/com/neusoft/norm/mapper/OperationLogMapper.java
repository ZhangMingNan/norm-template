package com.neusoft.norm.mapper;

import com.neusoft.norm.domain.OperationLog;
import com.neusoft.norm.domain.vo.SearchParams;

import java.util.List;

public interface OperationLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OperationLog record);

    int insertSelective(OperationLog record);

    OperationLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OperationLog record);

    int updateByPrimaryKeyWithBLOBs(OperationLog record);

    int updateByPrimaryKey(OperationLog record);

    List<OperationLog> findAll(SearchParams searchParams);
}