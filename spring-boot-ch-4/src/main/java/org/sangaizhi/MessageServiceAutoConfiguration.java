package org.sangaizhi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 根据 Message 提供的参数，并通过 @ConditionalOnClass 判断 MessageService 这个类在类路径是否存在，
 * 且当容器中没有这个 Bean 的情况下自动配置这个 Bean
 * @author sangaizhi
 * @date 2017/6/7
 */
@Configuration
@EnableConfigurationProperties(Message.class)
@ConditionalOnClass(MessageService.class)
@ConditionalOnProperty(prefix = "message", value = "enabled", matchIfMissing = true)
public class MessageServiceAutoConfiguration {
    @Autowired
    private Message message;

    @Bean
    @ConditionalOnMissingBean(MessageService.class)
    public MessageService messageService(){
        MessageService messageService = new MessageService();
        messageService.setMsg(message.getMsg());
        return messageService;
    }

}
