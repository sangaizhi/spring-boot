package org.sangaizhi;

/**
 * 判断依据类，
 * 本实例根据此类是否存在来创建这个类的 Bean,这个类可以是第三方类库的类
 * @author sangaizhi
 * @date 2017/6/7
 */

public class MessageService {
    private String msg;

    public String sayHello(){
        return "Hello" + msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
