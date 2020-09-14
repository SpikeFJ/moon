package com.moon.rule.annotation;

/**
 * 指定topic是针对哪个业务对象的
 * @author spikeF
 * @date 2020/9/11 9:11
 */
public @interface TopicFor {
    Class<?> value();
}
