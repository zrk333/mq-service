package com.zrk;

import com.zrk.topic.CourseSender;
import com.zrk.topic.OrderSender;
import com.zrk.topic.UserSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: zrk
 * @Date: 2019/12/3
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicTest {

    @Resource
    private UserSender userSender;

    @Resource
    private CourseSender courseSender;

    @Resource
    private OrderSender orderSender;

    @Test
    public void test(){
        userSender.send("用户服务日志");
        courseSender.send("课程服务日志");
        orderSender.send("订单服务日志");

    }

}
