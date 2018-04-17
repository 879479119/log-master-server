package com.logmaster.domain.enums;

/**
 * @author wanglu
 * @Description:
 * @Date: 2017/12/15.
 */

public enum DataTypeEnum {
    // 日志
    DATA_TYPE_LOG(1),
    // hive表
    DATA_TYPE_HIVE(2),
    // 业务
    DATA_TYPE_BUSINESS(3),
    // 页面
    DATA_TYPE_PAGE(4),
    // hive库
    DATA_TYPE_HIVE_DB(5);

    Integer id;

    DataTypeEnum(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

}
