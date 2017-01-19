package com.neusoft.norm.mapper;

import com.neusoft.norm.domain.Dict;
import com.neusoft.norm.domain.vo.SearchParams;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DictMapper {

    Dict findByTypeAndValue(@Param("type")String type, @Param("value")String value);

    List<Dict> findAll(SearchParams searchParams);
}