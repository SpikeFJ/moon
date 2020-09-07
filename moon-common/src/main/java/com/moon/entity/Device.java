package com.moon.entity;

import com.moon.rule.annotation.ProperyDesc;

/**
 * 设备档案
 *
 * @author spike
 */
public class Device extends BussionObject {

    @ProperyDesc("温度")
    private int a;

    @ProperyDesc("湿度")
    public String b;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public void reload() {
    }
}
