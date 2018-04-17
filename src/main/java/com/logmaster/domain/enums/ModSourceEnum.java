package com.logmaster.domain.enums;

/**
 * @author wanglu
 * @Description: 数据修改来源
 * @Date: 2017/12/15.
 */

public enum ModSourceEnum {
    // 新增
    MOD_SOURCE_ADD(1),
    // 编辑
    MOD_SOURCE_EDIT(2),
    // 系统操作
    MOD_SOURCE_SYSTEM(3),
    // DDL
    MOD_SOURCE_DDL(4);

    Integer id;

    ModSourceEnum(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

}
