package com.moon.rule.action;

import com.moon.rule.Action;
import com.moon.rule.Message;

/**
 * 打印
 *
 * @author spikeF
 * @date 2020/9/4 17:04
 */
public class ConsolePrint implements Action {

    public ConsolePrint(String message) {
        this.message = message;
    }

    private String message;

    @Override
    public void action(Message message) {
        //1. 打印固定的语句
        //2. 打印执行判断时的信息
        System.out.println(this.message);
    }
}
