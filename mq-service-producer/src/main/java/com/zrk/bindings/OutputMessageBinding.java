package com.zrk.bindings;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @Description: 定义绑定(消息发布者)
 * @Author: zrk
 * @Date: 2019/12/5
 */
public interface OutputMessageBinding {

    /**
     * Topic 名称
     */
    String OUTPUT = "message-center-out";

    @Output(OUTPUT)
    MessageChannel output();

}
