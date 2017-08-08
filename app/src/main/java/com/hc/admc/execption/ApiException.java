package com.hc.admc.execption;

/**
 * Created by alex on 2017/8/8.
 */

public class ApiException extends RuntimeException {
    public int code;
    public String message;

    public ApiException(Throwable throwable, int code) {
        super(throwable);
        this.code = code;
    }
}
