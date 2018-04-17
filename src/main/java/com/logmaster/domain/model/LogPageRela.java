package com.logmaster.domain.model;

import java.util.Date;

/**
 * @author wanglu
 * @Description:
 * @Date: 2017/10/17.
 */

public class LogPageRela {

    private Integer id;

    private Integer businessRelaId;

    private Integer pageId;

    private Date updateTime;

    public LogPageRela(Integer businessRelaId, Integer pageId) {
        this.businessRelaId = businessRelaId;
        this.pageId = pageId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBusinessRelaId() {
        return businessRelaId;
    }

    public void setBusinessRelaId(Integer businessRelaId) {
        this.businessRelaId = businessRelaId;
    }

    public Integer getPageId() {
        return pageId;
    }

    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
