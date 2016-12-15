package com.neusoft.norm.domain.vo;

/**
 * 作者: 张明楠 创建于 16/10/5.
 */
import lombok.ToString;
@ToString
public class PageRequest {
    private int pageNum =1;
    private int pageSize = 10;
    private boolean count;
    private  Boolean reasonable;
    private  Boolean pageSizeZero;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isCount() {
        return count;
    }

    public void setCount(boolean count) {
        this.count = count;
    }

    public Boolean getReasonable() {
        return reasonable;
    }

    public void setReasonable(Boolean reasonable) {
        this.reasonable = reasonable;
    }

    public Boolean getPageSizeZero() {
        return pageSizeZero;
    }

    public void setPageSizeZero(Boolean pageSizeZero) {
        this.pageSizeZero = pageSizeZero;
    }
}
