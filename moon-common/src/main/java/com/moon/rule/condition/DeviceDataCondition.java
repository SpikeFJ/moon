package com.moon.rule.condition;

import com.moon.entity.Device;
import com.moon.rule.Condition;
import com.moon.rule.Message;

import java.lang.reflect.Field;
import java.util.function.Predicate;

/**
 * 设备数据条件。
 *
 * @author spike
 */
public class DeviceDataCondition implements Condition {

    //条件判断三要素：
    // who(Device业务对象中的TmpA)
    // 表达式：>28度
    private Field field;
//    private Predicate<Device> express = x -> x.getA() > standardValue;
    private String standardValue;


    @Override
    public boolean check(Message message) {
        return false;
    }

    @Override
    public String getTopic() {
        return null;
    }
}
