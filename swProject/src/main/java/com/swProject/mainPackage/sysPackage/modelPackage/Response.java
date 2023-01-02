package com.swProject.mainPackage.sysPackage.modelPackage;

public class Response<T> {

    private boolean status;
    private String msg;
    public T object;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String message) {
        this.msg = message;
    }
}
