package com.moon.rule;

/**
 * 触发器包含消息，条件和动作。
 * <p>
 * 通过事件触发接受到某种消息，消息中包含条件判断需要的信息
 * <p>
 * 判断是否满足某个条件 执行某个动作。
 *
 * <p>
 * 典型场景：
 * 1. 瞬时数据判断
 * 1)单个数据判断
 * A设备温度超过 38 ，发送短信报警/ B设备开启
 * 2)多个数据联合判断
 * A设备温度超过38，且当前B设备处于XX状态，则发送短信报警/ C设备开启
 * <p>
 * 瞬时数据，需要在数据产生方通过消息中间件传递通知，通知包括数据本身，避免消费方再次主动查询。
 * <p>
 * 2. 过程数据判断
 * 1) A设备持续N分钟没有数据
 * 从A设备的最后一次有数据计算，所以每次数据到达时，都要开始一个计算任务
 * <p>
 * 2) A设备持续N分钟数据越限
 * 从A设备的最后一次有数据计算，所以每次数据到达时，都要开始一个计算任务
 *
 * @author spike
 */
public abstract class Trigger {

    /**
     * 消息
     */
    public Message message;

    /**
     * 条件
     *
     * @return
     */
    public Condition condition;

    /**
     * 动作
     *
     * @return
     */
    public Action action;

    /**
     * 触发器执行
     */
    public void doCheck(Message message) {
        if (condition.execute()) {
            action.action();
        }
    }

    public void start() {
        //监听消息中间件
    }

    public abstract String getTopic();
}
