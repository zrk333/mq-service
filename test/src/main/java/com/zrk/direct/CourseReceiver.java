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
        value = @Queue(value = "${mq.config.queue.course.name}",autoDelete = "true"),
        exchange = @Exchange(value = "${mq.config.exchange.msg}",type = ExchangeTypes.DIRECT),
        key = "${mq.config.queue.course.routing.key}"
    )
)
public class CourseReceiver {

    @RabbitHandler
    public void process(String msg){
        System.out.println("course receiver >>> " + msg);
    }
}
