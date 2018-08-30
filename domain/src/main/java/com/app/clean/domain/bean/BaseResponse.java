package com.app.clean.domain.bean;

public class BaseResponse {

    private int error_code;
    private String reason;
    private ResponseData result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason == null ? "" : reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResponseData getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "error_code=" + error_code +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }

    public void setResult(ResponseData result) {
        this.result = result;
    }
}
