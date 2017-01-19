package com.neusoft.norm.service.impl;

import com.neusoft.norm.domain.Dict;
import com.neusoft.norm.domain.vo.SearchParams;
import com.neusoft.norm.mapper.DictMapper;
import com.neusoft.norm.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 作者: 张明楠 创建于 17/1/16.
 */
@Service
public class DictServiceImpl implements DictService {

    @Autowired
    DictMapper dictMapper;


    @Override
    public List<Dict> findAll(SearchParams searchParams) {
        return dictMapper.findAll(searchParams);
    }
}
