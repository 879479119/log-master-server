package com.logmaster.api.response.base;

/**
 * @author wanglu
 * @Description: 分页
 * @Date: 2017/09/26.
 */

public class PageResponse {

    private Integer totalItems;

    private Integer pageSize;

    private Integer pageNum;

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
