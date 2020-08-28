package com.moon.rule;

/**
 * 条件
 *
 * @author spike
 */
public interface Condition {
    /**
     * 条件执行
     *
     * @return
     */
    boolean execute();

    /**
     * 设置传递消息
     *
     * @param message
     */
    void setMessage(Message message);
}
