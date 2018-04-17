package com.logmaster.api.response.base;

/**
 * @author wanglu
 * @Description:
 * @Date: 2017/10/16.
 */
public class RespMeta {
    private int code = -1;
    private String errorType;
    private String errorMsg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "RespMeta{" + "code=" + code + ", errorType='" + errorType + '\''
                + ", errorMsg='" + errorMsg + '\'' + '}';
    }
}
