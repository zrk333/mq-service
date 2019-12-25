package com.zrk.fanout;

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
public class CreateOrderSender {

    @Resource
    private AmqpTemplate rabbitAmqpTemplate;

    @Value("${mq.config.exchange.order}")
    private String exChange;


    public void send(String msg){
        rabbitAmqpTemplate.convertAndSend(exChange,"",msg);
    }

}
