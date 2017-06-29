package org.sangaizhi.springboot.exception;

import java.io.Serializable;
import java.util.Map;

/**
 * 全局异常
 * @author sangaizhi
 * @date 2017/6/28
 */
public class GlobalException extends RuntimeException implements Serializable{
    private static final long serialVersionUID = -4453231439181616823L;

    /**
     * 错误编码
     */
    private String code;

    /**
     * 错误信息
     */
    private String message;

    /**
     * 需要传递的错误信息
     */
    private Map<String, Object> errorMap;


    private Throwable throwable;


    public GlobalException(String code, String message) {
        this(code, message, (Map<String, Object>)null);
    }

    public GlobalException(String code, String message, Throwable throwable) {
        this(code, message, null, throwable);
    }

    public GlobalException(String code, String message, Map<String, Object> errorMap) {
        this.code = code;
        this.message = message;
        this.errorMap = errorMap;
    }


    public GlobalException(String code, String message, Map<String, Object> errorMap, Throwable throwable) {
        this.code = code;
        this.message = message;
        this.errorMap = errorMap;
        this.throwable = throwable;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getErrorMap() {
        return errorMap;
    }

    public void setErrorMap(Map<String, Object> errorMap) {
        this.errorMap = errorMap;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
