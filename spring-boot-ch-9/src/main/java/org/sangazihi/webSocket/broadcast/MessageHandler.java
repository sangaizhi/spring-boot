package org.sangazihi.webSocket.broadcast;

import org.sangazihi.webSocket.message.ReceiveMessage;
import org.sangazihi.webSocket.message.SendMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * @author sangaizhi
 * @date 2017/6/14
 */
@Controller
public class MessageHandler {

    /**
     * 浏览器向服务器发送消息
     * 服务器向浏览器发送消息
     *  @MessageMapping 注解：
     *     映射浏览器向服务器发送消息的地址，类似于 @RequestMapping
     *  @SendTo 当服务器接收到消息时，会对订阅了 @SendTo 路径中的浏览器发送消息
     *
     * @param message
     * @return
     * @throws InterruptedException
     */
    @MessageMapping("/say")
    @SendTo("/topic/getResponse")
    public SendMessage say(ReceiveMessage message) throws InterruptedException {
        Thread.sleep(3000);
        return new SendMessage(message.getName(),message.getMessage());
    }
}
