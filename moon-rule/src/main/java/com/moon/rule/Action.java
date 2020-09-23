package com.moon.rule;

/**
 * 动作对象
 *
 * @author spike
 */
public interface Action {

    /**
     * 执行动作
     */
    void execute(Message message);
}
