package com.moon.rule;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

public class ServiceMain {

    public static void main(String[] args) {
        //1.监听mq
        //2.接受到消息

        // 触发器监听的事件与业务对象相关，如设备可能都是监听的topic_device_archive,
        // topic_device_archive 包含不同的消息类型：新增、删除
        // topic_device_data 包含不同的数据：温度、湿度等

        //
        Trigger trigger  = new DefaultTrigger();
        trigger.start();
    }

}
