package com.moon.rule.device;

import com.moon.entity.Device;
import com.moon.rule.Condition;

/**
 * 设备条件
 *
 * @author spike
 */
public abstract class DeviceCondition implements Condition {

    public abstract boolean check(Device device);

}
