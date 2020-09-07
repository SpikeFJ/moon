package com.moon.rule;

/**
 * 当什么时候触发。
 * <p>
 * 包括触发的Topic(Topic这个概念来自消息中间件，当订阅者订阅了相关topic,就会收到消息通知)
 * <p>
 * desc:主要用于界面显示，如当数据上报时，当设备新建时
 *
 * @author spikeF
 * @date 2020/9/7 15:14
 */
public interface When {

    String topic();

    String desc();
}
