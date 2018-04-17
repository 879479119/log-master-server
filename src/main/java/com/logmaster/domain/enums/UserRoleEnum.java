package com.logmaster.domain.enums;

/**
 * @author wanglu
 * @Description:
 * @Date: 2017/12/12.
 */

public enum UserRoleEnum {

    // 普通用户
    ORDINARY(0),
    // rd
    RD(1),
    // 管理员
    ADMIN(2),
    // 超级管理员
    SUPER_ADMIN(3);
    private Integer role;

    public Integer getRole() {
        return role;
    }

    UserRoleEnum(Integer role) {
        this.role = role;
    }

}
