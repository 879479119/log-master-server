package com.logmaster.domain.model;

import java.util.List;

/**
 * @author wanglu
 * @Description:
 * @Date: 2017/10/17.
 */

public class App {

    private Integer appId;

    private String appName;

    private List<AppPlatform> platformList;

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

    public List<AppPlatform> getPlatformList() {
        return platformList;
    }

    public void setPlatformList(List<AppPlatform> platformList) {
        this.platformList = platformList;
    }
}
