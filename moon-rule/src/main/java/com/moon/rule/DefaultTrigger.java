package com.moon.rule;

import java.util.EventListener;
import java.util.EventObject;

/**
 * @author spikeF
 * @date 2020/9/8 8:52
 */
public class DefaultTrigger extends Trigger implements EventListener {
    @Override
    public void start() {
        //.addListener(this);
    }

    @Override
    public Message messageToAction(Message input) {
        return input;
    }


    public void onChanged(EventObject object) {
        Message message = null;//from object
        doCheck(message);
    }
}
