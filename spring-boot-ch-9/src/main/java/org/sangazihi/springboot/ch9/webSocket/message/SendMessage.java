package org.sangazihi.webSocket.message;

/**
 * 服务器向浏览器发送的消息
 * @author sangaizhi
 * @date 2017/6/14
 */
public class SendMessage {

    private String name;
    private String message;

    public SendMessage(){}
    public SendMessage(String name, String message){
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
