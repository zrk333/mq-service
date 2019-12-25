package com.zrk.direct;

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
        value = @Queue(value = "${mq.config.queue.user.name}",autoDelete = "true"),
        exchange = @Exchange(value = "${mq.config.exchange.msg}",type = ExchangeTypes.DIRECT),
        key = "${mq.config.queue.user.routing.key}"
    )
)
public class UserReceiver {

    @RabbitHandler
    public void process(String msg){
        System.out.println("user receiver >>> " + msg);
    }
}
