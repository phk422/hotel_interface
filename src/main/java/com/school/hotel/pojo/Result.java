package com.school.hotel.pojo;

/**
 * @Description 返回的结果对象
 * @Autor Peng hk
 * @Date 2021/2/28
 **/
public class Result<T> {
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";
    private String message;
    private T result;

    public Result() {
    }

    public Result(String message, T result) {
        this.message = message;
        this.result = result;
    }

    public Result(T result) {
        this.message = SUCCESS;
        this.result = result;
    }

    public static String getSUCCESS() {
        return SUCCESS;
    }

    public static String getERROR() {
        return ERROR;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public static Result success(Object result) {
        return new Result(result);
    }

    public static Result error(Object result) {
        return new Result(ERROR, result);
    }
}
