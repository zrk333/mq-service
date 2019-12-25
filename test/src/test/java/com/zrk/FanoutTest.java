package com.zrk;

import com.zrk.fanout.CreateOrderSender;
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
public class FanoutTest {

    @Resource
    private CreateOrderSender createOrderSender;

    @Test
    public void test(){
        createOrderSender.send("生成订单");
    }

}
