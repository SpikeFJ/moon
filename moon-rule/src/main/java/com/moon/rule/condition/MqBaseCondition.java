package com.moon.rule.condition;

import com.moon.entity.Device;
import com.moon.rule.Condition;
import com.moon.rule.Message;
import com.moon.rule.annotation.ExportProperty;

import java.util.function.BiFunction;

/**
 * 设备数据条件。
 *
 * @author spike
 */
public class MqBaseCondition implements Condition {

    public Class<?> aClass;//哪个业务对象
    public ExportProperty field;//哪个字段
    public String compareOperation;//比较符
    public String standardValue;//基准值

    public BiFunction<Device, String, Boolean> func;

    @Override
    public boolean evaluate(Message message) {
        int deviceId = (int) message.attachData.get("deviceId");

        Device device = getDevice(deviceId);
        return func.apply(device, this.standardValue);
    }

    private Device getDevice(int deviceId) {
        return null;
    }

    public String getTopic() {
        return null;
    }


    public BiFunction<Device, String, Boolean> getFunc(int type, int standardValue) {
        if (type == 0) {
            return (device, s) -> device.toString().equals(s);
        }

        return (device, s) -> {
            return true;
        };
    }
}
