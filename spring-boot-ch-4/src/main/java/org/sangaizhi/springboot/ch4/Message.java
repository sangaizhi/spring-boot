package org.sangaizhi.springboot.ch4;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author sangaizhi
 * @date 2017/6/7
 */
@ConfigurationProperties(prefix = "message")
public class Message {

    private static final String MSG = "world";
    private String msg = MSG;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
