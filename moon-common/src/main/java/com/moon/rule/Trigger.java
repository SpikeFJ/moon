package com.moon.rule;

import java.util.EventListener;
import java.util.List;

/**
 * 触发器包含消息，条件和动作。
 * 通过事件触发接受到某种消息，消息中包含条件判断需要的信息（when)
 * 判断是否满足某个条件 执行某个动作。
 * ************************************************************
 * 触发器首先是和业务对象绑定的。
 * 首先选择设备，选择设备能够选择的条件+可以执行的动作
 * ***************************************************
 * 典型场景：
 * 1. 瞬时数据判断
 * 1)单个数据判断
 * A设备温度超过 38 ，发送短信报警/ B设备开启
 * 2)多个数据联合判断
 * A设备温度超过38，且当前B设备处于XX状态，则发送短信报警/ C设备开启
 * <p>
 * 瞬时数据，需要在数据产生方通过消息中间件传递通知，通知包括数据本身，避免消费方再次主动查询。
 * *************************************************************
 * 2. 过程数据判断
 * 1) A设备持续N分钟没有数据
 * 从A设备的最后一次有数据计算，所以每次数据到达时，都要开始一个计算任务
 * <p>
 * 2) A设备持续N分钟数据越限
 * 从A设备的最后一次有数据计算，所以每次数据到达时，都要开始一个计算任务
 * <p>
 * <p>
 * 所有的事件通知都是用来触发条件判断以及后续执行，
 * 所有的事件数据都是用来填充业务对象的
 * <p>
 * 后续所有的判断都是基于内存中的业务对象来判断
 *
 * @author spike
 */
public abstract class Trigger {

    /**
     * 触发时机，主要是确定监听Topic：时机是由Topic确定。
     * <p>
     * 时机又是由业务对象决定的：
     * 如设备 有：设备创建时，设备数据上报时
     * <p>
     * 可以没有时机，那就直接开启线程判断条件。
     */
    private List<When> when;

    /**
     * 消息
     */
    private Message message;

    /**
     * 条件
     *
     * @return
     */
    private Condition condition;

    /**
     * 动作
     *
     * @return
     */
    private Action action;

    /**
     * 事件驱动该方法检测
     */
    public void doCheck(Message message) {
        if (condition.evaluate(message)) {
            action.execute(messageToAction(message));
        }
    }

    /**
     * 1.如果通知依赖于第三方中间件，如mq，则在start中订阅相关topic
     * 2.如果不依赖于第三方，直接方法间调用，则使用观察者模式，在start中将自身作为监听者添加到观察者主题中。
     */
    public abstract void start();

    /**
     * 组织执行action需要的参数
     * @param input
     * @return
     */
    public abstract Message messageToAction(Message input);

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
