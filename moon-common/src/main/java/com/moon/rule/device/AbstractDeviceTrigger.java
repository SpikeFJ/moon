package com.moon.rule.device;

import com.moon.entity.Device;
import com.moon.rule.Condition;
import com.moon.rule.Trigger;

/**
 * 设备触发器。
 * 分为档案类和数据类：
 * 1. 档案类
 * 当新建某个设备时，如果设备属于A类型，则发送短信通知
 * <p>
 * 2. 数据类
 * 当接收到AA数据，且数据越限时，通知
 *
 * @author spike
 */
//@Entity(业务对象)
public abstract class AbstractDeviceTrigger extends Trigger {
}
