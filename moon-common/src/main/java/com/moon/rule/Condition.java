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
     * @param message 参数
     * @return
     */
    boolean check(Message message);

    /**
     * 需要订阅的事件
     *
     * @return
     */
    String getTopic();
}
