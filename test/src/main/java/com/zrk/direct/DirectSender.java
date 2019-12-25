package com.zrk.direct;

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
public class DirectSender {

    @Resource
    private AmqpTemplate rabbitAmqpTemplate;

    @Value("${mq.config.exchange.msg}")
    private String exChange;

    @Value("${mq.config.queue.user.routing.key}")
    private String routingKeyUser;

    @Value("${mq.config.queue.course.routing.key}")
    private String routingKeyCourse;

    public void sendUser(String msg){
        rabbitAmqpTemplate.convertAndSend(exChange,routingKeyUser,msg);
    }

    public void sendCourse(String msg){
        rabbitAmqpTemplate.convertAndSend(exChange,routingKeyCourse,msg);
    }
}
