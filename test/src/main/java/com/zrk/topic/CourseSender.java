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
public class CourseSender {

    @Resource
    private AmqpTemplate rabbitAmqpTemplate;

    @Value("${mq.config.exchange.log}")
    private String exChange;

    public void send(String msg){
        rabbitAmqpTemplate.convertAndSend(exChange,"course.log.debug","course.log.debug" + msg);
        rabbitAmqpTemplate.convertAndSend(exChange,"course.log.info","course.log.info" + msg);
        rabbitAmqpTemplate.convertAndSend(exChange,"course.log.warn","course.log.warn" + msg);
        rabbitAmqpTemplate.convertAndSend(exChange,"course.log.error","course.log.error" + msg);

    }
}
