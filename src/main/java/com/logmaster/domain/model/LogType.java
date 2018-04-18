package com.logmaster.domain.model;

import java.util.List;

public class LogType {

    private Integer id;

    private String name;

    private String description;

    private List<LogSubType> logSubTypeList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<LogSubType> getLogSubTypeList() {
        return logSubTypeList;
    }

    public void setLogSubTypeList(List<LogSubType> logSubTypeList) {
        this.logSubTypeList = logSubTypeList;
    }
}
