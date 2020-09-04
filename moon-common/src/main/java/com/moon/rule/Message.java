package com.moon.rule;

import java.util.HashMap;
import java.util.Map;

/**
 * 事件传递消息
 *
 * @author spike
 */
public class Message {
    /**
     * 消息类型。 00：设备档案 01：设备数据 02：设备操作 11：用户操作 。。。
     */
    public int messageType;

    /**
     * 附加数据
     */
    public Map<String, Object> attachData;

}
