package com.neusoft.norm.mapper;

import com.neusoft.norm.domain.Dict;
import org.apache.ibatis.annotations.Param;

public interface DictMapper {

    Dict findByTypeAndValue(@Param("type")String type, @Param("value")String value);
}