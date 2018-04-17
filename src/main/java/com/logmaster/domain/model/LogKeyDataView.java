package com.logmaster.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * @author wanglu
 * @Description:
 * @Date: 2017/10/17.
 */

public class LogKeyDataView {

    private Integer id;

    private Integer dataId;

    private Integer keyId;

    private String keyName;

    private String keyNameCn;

    private Integer keyTypeId;

    private String keyTypeName;

    private Boolean required;

    private List<String> defaultValue;

    private String regex;

    private String keyDescription;

    private String description;

    private Boolean showType;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /**
     * 默认构造.
     */
    public LogKeyDataView() {
    }

    /**
     * 构造函数.
     * @param keyId keyId
     * @param required 是否为空
     * @param defaultValue 默认值
     * @param regex 正则
     * @param description 描述
     */
    public LogKeyDataView(Integer keyId, Boolean required, List<String> defaultValue, String regex, String description) {
        this.keyId = keyId;
        this.required = required;
        this.defaultValue = defaultValue;
        this.regex = regex;
        this.description = description;
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

    public Integer getKeyId() {
        return keyId;
    }

    public void setKeyId(Integer keyId) {
        this.keyId = keyId;
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

    public List<String> getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(List<String> defaultValue) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getShowType() {
        return showType;
    }

    public void setShowType(Boolean showType) {
        this.showType = showType;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
