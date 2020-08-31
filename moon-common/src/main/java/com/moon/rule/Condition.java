package com.moon.rule;

/**
 * 条件
 *
 * @author spike
 */
public interface Condition {

    /**
     * 执行条件判断
     *
     * @param message 参数
     * @return
     */
    boolean check(Message message);
}
