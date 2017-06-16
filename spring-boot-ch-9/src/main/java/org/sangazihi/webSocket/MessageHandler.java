package org.sangazihi.webSocket;

import org.sangazihi.webSocket.message.ReceiveMessage;
import org.sangazihi.webSocket.message.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.support.ExecutorSubscribableChannel;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * @author sangaizhi
 * @date 2017/6/14
 */
@Controller
public class MessageHandler {

    private SimpMessagingTemplate messagingTemplate = new SimpMessagingTemplate(new ExecutorSubscribableChannel());


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

    @MessageMapping("/chat")
    public void handlerChat(Principal principal, ReceiveMessage message){
        if(principal.getName().equals("sangaizhi")){
            messagingTemplate.convertAndSendToUser("sangzongjie","queue/notifications", principal.getName()+"-send:"+message.getMessage());
        }else{
            messagingTemplate.convertAndSendToUser("sangaizhi","queue/notifications", principal.getName()+"-send:"+message.getMessage());
        }
    }
}
