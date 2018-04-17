package com.logmaster.domain.enums;

/**
 * @author wanglu
 * @Description: 用户关注
 * @Date: 2017/11/06.
 */
public enum UserFavouriteEnum {
    /*日志*/
    LOG(1),
    /*hive表*/
    HIVE_TABLE(2);

    private Integer dataType;

    UserFavouriteEnum(Integer dataType) {
        this.dataType = dataType;
    }

    public Integer getDataType() {
        return dataType;
    }
}
