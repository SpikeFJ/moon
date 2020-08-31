package com.moon.entity;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

public class Acccount extends BussionObject {

    private List<EventListener> deviceListeners = new ArrayList<>();

    @Override
    public void save() {
        fireBeforeSave();
        super.save();
    }

    private void fireBeforeSave()
    {
        for (EventListener deviceListener : deviceListeners) {

        }
    }
}

