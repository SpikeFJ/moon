package com.moon.rule.annotation;

/**
 * 对外暴露的可监听的属性
 * @author spikeF
 * @date 2020/9/4 17:46
 */
public @interface ExportProperty {
    /**
     * 属性名
     *
     * @return
     */
    String name();

    /**
     * 页面显示
     *
     * @return
     */
    String label();

    /**
     * 订阅消息
     *
     * @return
     */
    String topic();
}
