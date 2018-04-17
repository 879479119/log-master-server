package com.logmaster.domain.enums;

/**
 * @author wanglu
 * @Description:
 * @Date: 2017/10/16.
 */
public enum ErrorCodeEnum {

    // 0不可用，0默认为成功的CODE
    LISTERROR(1, "获取列表失败！"),
    DETAILERROR(2, "获取数据失败！"),
    SAVEERROR(3, "保存失败！"),
    UPDATEERROR(4, "更新失败！"),
    DELETEERROR(5, "删除数据失败！"),
    AUDITERROR(6, "审核任务失败"),
    CLAIMERROR(7, "认领任务失败"),
    BACKERROE(8, "回退任务失败"),
    STARTERROE(9, "启动流程失败"),
    TOKENERROE(10, "认证失败"),
    VALIDATEERROE(11, "校验失败");
    private Integer errorCode;
    private String errorName;

    ErrorCodeEnum(Integer errorCode, String errorName) {
        this.errorCode = errorCode;
        this.errorName = errorName;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getErrorName() {
        return errorName;
    }
}
