package com.logmaster.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.logmaster.application.constants.LogConstants;
import com.logmaster.application.utils.Check;

import java.util.Date;
import java.util.List;


/**
 * @author wanglu
 * @Description:
 * @Date: 2017/10/17.
 */

public class LogDataView {

    private Integer id;

    private String dataName;

    private String dataNameCn;

    private String task;

    private Integer appId;

    private String appName;

    private Integer platformId;

    private String platformListStr = "";

    private List<LogAppVersionView> versionList;

    private String versionListStr = "";

    private List<LogBusinessRelaView> businessList;

    private Integer businessId;

    private String businessListStr = "";

    private String pageListStr = "";

    private Integer pageId;

    private Integer logLevelId;

    private String logLevelName;

    private Integer logTypeId;

    private String logTypeName;

    private String creator;

    private String devManager;

    private String testManager;

    private String productManager;

    private String reviewManager;

    private String description;

    private String testDescription;

    private List<LogKeyDataView> keyDataList;

    private List<BaseKeyView> baseKeyList;

    private Integer status;

    private String statusStr;

    private Boolean effective;

    private Boolean favourite;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public String getDataNameCn() {
        return dataNameCn;
    }

    public void setDataNameCn(String dataNameCn) {
        this.dataNameCn = dataNameCn;
    }

    public String getTask() {
        return task;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public Integer getPageId() {
        return pageId;
    }

    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    /**
     * 返回以逗号分隔的平台名.
     *
     * @return 平台名集合.
     */
    public String getPlatformListStr() {
        if (Check.notEmpty(versionList)) {
            versionList.forEach(version -> platformListStr = platformListStr + version.getPlatformName() + ",");
            return platformListStr.substring(0, platformListStr.length() - 1);
        }
        return platformListStr;
    }

    public void setPlatformListStr(String platformListStr) {
        this.platformListStr = platformListStr;
    }

    public List<LogAppVersionView> getVersionList() {
        return versionList;
    }

    public void setVersionList(List<LogAppVersionView> versionList) {
        this.versionList = versionList;
    }

    /**
     * 返回以逗号分隔的app版本名.
     *
     * @return app版本名集合
     */
    public String getVersionListStr() {
        if (Check.notEmpty(versionList)) {
            versionList.forEach(version -> versionListStr = versionListStr + version.getVersionCode() + ",");
            return versionListStr.substring(0, versionListStr.length() - 1);
        }
        return versionListStr;
    }

    public void setVersionListStr(String versionListStr) {
        this.versionListStr = versionListStr;
    }

    public List<LogBusinessRelaView> getBusinessList() {
        return businessList;
    }

    public void setBusinessList(List<LogBusinessRelaView> businessList) {
        this.businessList = businessList;
    }

    /**
     * 返回以逗号分隔的业务名.
     *
     * @return 业务名集合.
     */
    public String getBusinessListStr() {
        if (Check.notEmpty(businessList)) {
            businessList.forEach(business -> businessListStr = businessListStr + business.getName() + ",");
            return businessListStr.substring(0, businessListStr.length() - 1);
        }
        return businessListStr;
    }

    public void setBusinessListStr(String businessListStr) {
        this.businessListStr = businessListStr;
    }

    /**
     * 返回以逗号分隔的页面名.
     *
     * @return 页面名集合
     */
    public String getPageListStr() {
        if (Check.notEmpty(businessList)) {
            businessList.forEach(business -> {
                List<Page> pageList = business.getPageList();
                if (Check.notEmpty(pageList)) {
                    pageList.forEach(page -> pageListStr = pageListStr + page.getName() + ",");
                    pageListStr = pageListStr.substring(0, pageListStr.length() - 1);
                }
            });
        }
        return pageListStr;
    }

    public void setPageListStr(String pageListStr) {
        this.pageListStr = pageListStr;
    }

    public Integer getLogLevelId() {
        return logLevelId;
    }

    public void setLogLevelId(Integer logLevelId) {
        this.logLevelId = logLevelId;
    }

    public String getLogLevelName() {
        return logLevelName;
    }

    public void setLogLevelName(String logLevelName) {
        this.logLevelName = logLevelName;
    }

    public Integer getLogTypeId() {
        return logTypeId;
    }

    public void setLogTypeId(Integer logTypeId) {
        this.logTypeId = logTypeId;
    }

    public String getLogTypeName() {
        return logTypeName;
    }

    public void setLogTypeName(String logTypeName) {
        this.logTypeName = logTypeName;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Integer getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Integer platformId) {
        this.platformId = platformId;
    }

    public String getDevManager() {
        return devManager;
    }

    public void setDevManager(String devManager) {
        this.devManager = devManager;
    }

    public String getProductManager() {
        return productManager;
    }

    public void setProductManager(String productManager) {
        this.productManager = productManager;
    }

    public String getReviewManager() {
        return reviewManager;
    }

    public void setReviewManager(String reviewManager) {
        this.reviewManager = reviewManager;
    }

    public String getTestManager() {
        return testManager;
    }

    public void setTestManager(String testManager) {
        this.testManager = testManager;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTestDescription() {
        return testDescription;
    }

    public void setTestDescription(String testDescription) {
        this.testDescription = testDescription;
    }

    public List<LogKeyDataView> getKeyDataList() {
        return keyDataList;
    }

    public void setKeyDataList(List<LogKeyDataView> keyDataList) {
        this.keyDataList = keyDataList;
    }

    public List<BaseKeyView> getBaseKeyList() {
        return baseKeyList;
    }

    public void setBaseKeyList(List<BaseKeyView> baseKeyList) {
        this.baseKeyList = baseKeyList;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public String getStatusStr() {
        return LogConstants.KEY_STATUS_MAP.get(this.status);
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public Boolean getEffective() {
        return effective;
    }

    public void setEffective(Boolean effective) {
        this.effective = effective;
    }

    public Boolean getFavourite() {
        return favourite;
    }

    public void setFavourite(Boolean favourite) {
        this.favourite = favourite;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
