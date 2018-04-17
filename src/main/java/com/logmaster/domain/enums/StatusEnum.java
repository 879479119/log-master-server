package com.logmaster.domain.enums;

/**
 * @author wanglu
 * @Description: status枚举，0和1,用于一些需要表示是否的地方
 * @Date: 2017/10/16.
 */
public enum StatusEnum {
    // 有效
    EFFECTIVE(1),
    // 无效
    INVALID(0);

    private Integer status;

    public Integer getStatus() {
        return status;
    }

    StatusEnum(Integer status) {
        this.status = status;
    }
}
