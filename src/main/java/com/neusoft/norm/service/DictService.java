package com.neusoft.norm.service;

import com.neusoft.norm.domain.Dict;
import com.neusoft.norm.domain.vo.SearchParams;

import java.util.List;

/**
 * 作者: 张明楠 创建于 17/1/16.
 */
public interface DictService {
    List<Dict> findAll(SearchParams searchParams);
}
