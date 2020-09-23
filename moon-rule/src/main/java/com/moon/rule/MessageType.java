package com.moon.rule;

/**
 * 消息类型
 *
 * @author spikeF
 * @date 2020/9/4 16:52
 */
public class MessageType {

    //设备档案变更
    public static int DeviceArchiveChanged = 1 << 0;

    //设备属性变更
    public static int DevicePropertyChanged = 1 << 1;

    //设备数据上报
    public static int DeviceDataReported = 1 << 2;
}
