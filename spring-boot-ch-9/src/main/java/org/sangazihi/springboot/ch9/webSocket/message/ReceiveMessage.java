package org.sangazihi.webSocket.message;

/**
 * 接收到的浏览器向服务器发送的消息
 * @author sangaizhi
 * @date 2017/6/14
 */
public class ReceiveMessage {
    private String name ;
    private String message;

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
