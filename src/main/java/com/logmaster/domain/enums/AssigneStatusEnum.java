package com.logmaster.domain.enums;

/**
 * @author wanglu
 * @Description:
 * @Date: 2017/12/08.
 */

public enum AssigneStatusEnum {
    // 有效
    ASSIGNE_TRUE(true),
    // 无效
    ASSIGNE_FALSE(false);

    private Boolean status;

    public Boolean getStatus() {
        return status;
    }

    AssigneStatusEnum(Boolean status) {
        this.status = status;
    }
}
