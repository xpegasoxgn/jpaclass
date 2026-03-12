package com.clasejava.demo_jpa.utils;

public class JsonResult {
    private boolean success;
    private String message;
    private Object data;
    // Constructor
    public JsonResult(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }
    public boolean isSuccess() {
        return success;
    }
    public String getMessage() {
        return message;
    }
    public Object getData() {
        return data;
    }
}
