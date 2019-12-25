package com.zrk;

import com.zrk.direct.DirectSender;
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
public class DirectTest {

    @Resource
    private DirectSender directSender;

    @Test
    public void testUserSend(){
        directSender.sendUser("用户详情");
    }

    @Test
    public void testCourseSend(){
        directSender.sendCourse("课程详情");
    }
}
