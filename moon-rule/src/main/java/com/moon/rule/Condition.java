package com.moon.rule;

/**
 * 条件。
 * <p>
 * 需要设置消息相关的配置：
 * <p>
 * 1.消息的订阅入口
 * 2.消息的格式，以方便从消息中提取条件判断需要的数据
 *
 * @author spike
 */
public interface Condition {

    /**
     * 执行条件判断
     *
     * @param message message参数包括条件判断需要的参数，如上报的数据，事件发生源等信息
     * @return
     */
    boolean evaluate(Message message);
}
