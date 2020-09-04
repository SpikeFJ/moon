package com.moon.rule.condition;

import com.moon.rule.Condition;
import com.moon.rule.Message;

/**
 * 时间条件，Cron表达式，当前时间作为输入参数
 * <p>
 * 一. 以当前时间作为判断依据
 * <p>
 * 1. 每周1开启设备XX
 * 2. 当前时间是否在8:00-18:00之间
 *
 * @author spikeF
 * @date 2020/9/4 16:25
 */
public class TimeCondition implements Condition {
    @Override
    public boolean check(Message message) {
        return false;
    }

    @Override
    public String getTopic() {
        return null;
    }
}
