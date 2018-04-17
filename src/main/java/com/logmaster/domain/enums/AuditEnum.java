package com.logmaster.domain.enums;

/**
 * @author wanglu
 * @Description:
 * @Date: 2017/12/08.
 */

public enum AuditEnum {

    // 通过
    AUDIT_PASS(1),
    // 驳回
    AUDIT_FAIL(2);

    private Integer status;

    public Integer getStatus() {
        return status;
    }

    AuditEnum(Integer status) {
        this.status = status;
    }

}
