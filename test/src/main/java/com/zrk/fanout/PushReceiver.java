package com.zrk.fanout;

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
        value = @Queue(value = "${mq.config.queue.push.name}",autoDelete = "true"),
        exchange = @Exchange(value = "${mq.config.exchange.order}",type = ExchangeTypes.FANOUT)
    )
)
public class PushReceiver {

    @RabbitHandler
    public void process(String msg){
        System.out.println("push receiver >>> " + msg);
    }
}
