package com.logmaster.domain.model;

import java.util.Date;

/**
 * @author wanglu
 * @Description:
 * @Date: 2017/10/17.
 */

public class LogBusinessRela {

    private Integer id;

    private Integer dataId;

    private Integer businessId;

    private Boolean collect;

    private String collectRule;

    private Date updateTime;

    public LogBusinessRela(Integer dataId, Integer businessId) {
        this.dataId = dataId;
        this.businessId = businessId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public Boolean isCollect() {
        return collect;
    }

    public void setCollect(Boolean collect) {
        this.collect = collect;
    }

    public String getCollectRule() {
        return collectRule;
    }

    public void setCollectRule(String collectRule) {
        this.collectRule = collectRule;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
