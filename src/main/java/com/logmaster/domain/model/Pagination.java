package com.logmaster.domain.model;
/**
 * @author wanglu
 * @Description:
 * @Date: 2017/10/17.
 */

public class Pagination {

    /** 数据列表开始序号（从0开始）.*/
    private int startNum;
    /** 分页大小.*/
    private int size;
    /** 请求页面序号（从0开始）.*/
    private int pageNum;
    /** 查询数据总数.*/
    private int totalNum;
    /** 查询筛选数据量.*/
    private int searchCount;
    /**  排序字段名.*/
    private String orderBy;
    /** 序方式, DESC OR ASC.*/
    private String orderType = "DESC";

    /**
     * 分页.
     *
     * @param startNum  起始页码
     * @param size      个数
     * @param orderBy   排序
     * @param orderType 排序类型
     */
    public Pagination(int startNum, int size, String orderBy, String orderType) {
        this.startNum = startNum;
        this.size = size;
        this.orderBy = orderBy;
        this.orderType = orderType;
    }

    /**
     * 分页.
     *
     * @param startNum 起始页码
     * @param size     个数
     * @param orderBy  排序
     */
    public Pagination(int startNum, int size, String orderBy) {
        this.startNum = startNum;
        this.size = size;
        this.orderBy = orderBy;
    }

    public Pagination(int startNum, int size) {
        this.startNum = startNum;
        this.size = size;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getSearchCount() {
        return searchCount;
    }

    public void setSearchCount(int searchCount) {
        this.searchCount = searchCount;
    }

    public int getStartNum() {
        return startNum;
    }

    public void setStartNum(int startNum) {
        this.startNum = startNum;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
}