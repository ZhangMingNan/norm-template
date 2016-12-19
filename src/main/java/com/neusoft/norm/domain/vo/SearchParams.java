package com.neusoft.norm.domain.vo;

import java.util.List;

import com.google.common.collect.Lists;
import lombok.ToString;
/**
 * 作者: 张明楠 创建于 16/12/19.
 */

@ToString
public class SearchParams {

    private List<Criteria> criterias = Lists.newArrayList();

    private PageRequest pageRequest = new PageRequest();

    public PageRequest getPageRequest() {
        return pageRequest;
    }

    public void setPageRequest(PageRequest pageRequest) {
        this.pageRequest = pageRequest;
    }

    public List<Criteria> getCriterias() {
        return criterias;
    }

    public void setCriterias(List<Criteria> criterias) {
        this.criterias = criterias;
    }
}
