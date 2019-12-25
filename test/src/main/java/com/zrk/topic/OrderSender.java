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
public class OrderSender {

    @Resource
    private AmqpTemplate rabbitAmqpTemplate;

    @Value("${mq.config.exchange.log}")
    private String exChange;

    public void send(String msg){
        rabbitAmqpTemplate.convertAndSend(exChange,"order.log.debug","order.log.debug" + msg);
        rabbitAmqpTemplate.convertAndSend(exChange,"order.log.info","order.log.info" + msg);
        rabbitAmqpTemplate.convertAndSend(exChange,"order.log.warn","order.log.warn" + msg);
        rabbitAmqpTemplate.convertAndSend(exChange,"order.log.error","order.log.error" + msg);

    }
}
