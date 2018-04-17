package com.logmaster.domain.enums;

/**
 * @author wanglu
 * @Description: 业务和页面关联关系
 * @Date: 2017/11/05.
 */
public enum BusinessPageRelaEnum {

    // level为1表示业务线
    BUSINESS_TO_PAGE(1),
    // level为2表示业务类别
    PAGE_TO_BUSINESS(2);

    private Integer relaType;

    BusinessPageRelaEnum(Integer relaType) {
        this.relaType = relaType;
    }

    public Integer getRelaType() {
        return relaType;
    }
}
