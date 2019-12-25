package com.zrk.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: zrk
 * @Date: 2019/12/3
 */
@Component
public class UserSender {

    @Resource
    private AmqpTemplate rabbitAmqpTemplate;

    @Value("${mq.config.exchange.log}")
    private String exChange;

    public void send(String msg){
        rabbitAmqpTemplate.convertAndSend(exChange,"user.log.debug","user.log.debug" + msg);
        rabbitAmqpTemplate.convertAndSend(exChange,"user.log.info","user.log.info" + msg);
        rabbitAmqpTemplate.convertAndSend(exChange,"user.log.warn","user.log.warn" + msg);
        rabbitAmqpTemplate.convertAndSend(exChange,"user.log.error","user.log.error" + msg);

    }
}
