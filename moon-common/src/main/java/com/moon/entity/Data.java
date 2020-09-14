package com.moon.entity;

import com.moon.rule.annotation.ProperyDesc;
import com.moon.rule.annotation.TopicFor;

/**
 * 数据
 *
 * @author spikeF
 * @date 2020/9/4 16:38
 */
@TopicFor(Device.class)
public class Data {

    @ProperyDesc(value = "温度", topic = "tmpAndOther")
    private int a;

    @ProperyDesc(value = "湿度", topic = "tmpAndOther")
    public String b;

    @ProperyDesc(value = "速度", topic = "speed")
    public String c;


    public void load() {

    }

    public void loadFromDb() {

    }
}
