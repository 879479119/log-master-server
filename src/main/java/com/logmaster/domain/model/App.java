package com.logmaster.domain.model;

import java.util.List;

/**
 * @author wanglu
 * @Description:
 * @Date: 2017/10/17.
 */

public class App {

    private Integer id;

    private String name;

    private List<AppPlatform> platformList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AppPlatform> getPlatformList() {
        return platformList;
    }

    public void setPlatformList(List<AppPlatform> platformList) {
        this.platformList = platformList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
