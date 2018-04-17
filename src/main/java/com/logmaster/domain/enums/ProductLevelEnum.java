package com.logmaster.domain.enums;

/**
 * @author wanglu
 * @Description: 产品线列表层级ID
 * @Date: 2017/10/15.
 */
public enum ProductLevelEnum {
    // level为1表示业务线
    PRODUCT(1),
    // level为2表示业务类别
    BUSINESS(2);

    private Integer level;

    ProductLevelEnum(Integer level) {
        this.level = level;
    }

    public Integer getLevel() {
        return level;
    }
}
