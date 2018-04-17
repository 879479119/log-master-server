package com.logmaster.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author wanglu
 * @Description:
 * @Date: 2017/10/17.
 */

public class BaseKeyView {

    private Integer id;

    private String keyName;

    private String keyNameCn;

    private Integer keyTypeId;

    private String keyTypeName;

    private Boolean required;

    private String defaultValue;

    private String regex;

    private String keyDescription;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getKeyNameCn() {
        return keyNameCn;
    }

    public void setKeyNameCn(String keyNameCn) {
        this.keyNameCn = keyNameCn;
    }

    public Integer getKeyTypeId() {
        return keyTypeId;
    }

    public void setKeyTypeId(Integer keyTypeId) {
        this.keyTypeId = keyTypeId;
    }

    public String getKeyTypeName() {
        return keyTypeName;
    }

    public void setKeyTypeName(String keyTypeName) {
        this.keyTypeName = keyTypeName;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public String getKeyDescription() {
        return keyDescription;
    }

    public void setKeyDescription(String keyDescription) {
        this.keyDescription = keyDescription;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
