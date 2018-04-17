package com.logmaster.domain.model;

import java.util.Date;

/**
 * @author wanglu
 * @Description:
 * @Date: 2017/10/17.
 */

public class LogVersionRela {

    private Integer id;

    private Integer dataId;

    private Integer versionId;

    private Date updateTime;

    public LogVersionRela(Integer dataId, Integer versionId) {
        this.dataId = dataId;
        this.versionId = versionId;
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

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
