package org.sangazihi.webSocket.point2point;

import org.sangazihi.webSocket.message.ReceiveMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * @author sangaizhi
 * @date 2017/6/14
 */
@Controller
public class MessageHandler {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat")
    public void handlerChar(Principal principal, ReceiveMessage message){
        if(principal.getName().equals("sangaizhi")){
            messagingTemplate.convertAndSendToUser("sangzongjie","/queue/notifications", principal.getName()+"-send:"+message.getMessage());
        }else{
            messagingTemplate.convertAndSendToUser("sangaizhi","/queue/notifications", principal.getName()+"-send:"+message.getMessage());
        }
    }

}
