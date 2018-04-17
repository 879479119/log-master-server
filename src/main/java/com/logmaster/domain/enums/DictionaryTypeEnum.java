package com.logmaster.domain.enums;

/**
 * @author wanglu
 * @Description:
 * @Date: 2017/10/17.
 */

public enum DictionaryTypeEnum {
    // 埋点等级
    TYPE_LOG_LEVEL(1, "埋点等级"),
    // 埋点类型
    TYPE_LOG_TYPE(2, "埋点类型"),
    // 平台类型
    TYPE_PLATFORM_TYPE(3, "平台类型"),
    // key字段类型
    TYPE_KEY_TYPE(4, "key类型"),
    // etl类型
    TYPE_ETL_TYPE(5, "etl类型"),
    // 数据层级
    TYPE_DW_LEVEL(6, "数据层级"),
    // 任务类型
    TYPE_TASK_TYPE(7, "任务类型"),
    // 任务类型
    TYPE_HIVE_GROUP_ACCOUNT_TYPE(8, "hive组账号");
    Integer id;
    String name;

    DictionaryTypeEnum(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
