package com.zrk.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: zrk
 * @Date: 2019/12/3
 */
@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "${mq.config.queue.error.name}",autoDelete = "true"),
        exchange = @Exchange(value = "${mq.config.exchange.log}",type = ExchangeTypes.TOPIC),
        key = "*.log.error"
    )
)
public class ErrorReceiver {

    @RabbitHandler
    public void process(String msg){
        System.out.println("error receiver >>> " + msg);
    }
}
