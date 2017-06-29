package org.sangaizhi.springboot.response;

/**
 * @author sangaizhi
 * @date 2017/6/28
 */
public class GlobalResponse {

    private Boolean status;
    private String message;
    private Object data;

    public GlobalResponse(){}
    public GlobalResponse(Boolean status){
        this.status = status;
    }
    public GlobalResponse(Boolean status, String message){
        this.status = status;
        this.message = message;
    }

    public GlobalResponse(Boolean status, String message, Object data){
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static GlobalResponse ok(){
        return new GlobalResponse(true);
    }
    public static GlobalResponse ok(String message){
        return new GlobalResponse(true, message);
    }
    public static GlobalResponse ok(String message, Object data){
        return new GlobalResponse(true, message, data);
    }

    public static GlobalResponse fail(){
        return new GlobalResponse(false);
    }
    public static GlobalResponse fail(String message){
        return new GlobalResponse(false, message);
    }
    public static GlobalResponse fail(String message, Object data){
        return new GlobalResponse(false, message, data);
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
