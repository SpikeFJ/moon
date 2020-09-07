package com.moon.rule;

import java.util.EventListener;

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
 *
 *
 * 所有的事件通知都是用来触发条件判断以及后续执行，
 * 所有的事件数据都是用来填充业务对象的
 *
 * 后续所有的判断都是基于内存中的业务对象来判断
 *
 *
 * @author spike
 */
public class Trigger implements EventListener {

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
        if (condition.check(message)) {

            Message tmpMessage = new Message();
            tmpMessage.attachData.put("statment", "这是一个测试");
            action.action(tmpMessage);
        }
    }

    public void start() {
        if (condition.getTopic() != "") {
            //1.开启消息监听
            //2.设置回调函数为doCheck
        }
    }

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
