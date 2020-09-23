package com.moon.rule;

import com.moon.entity.Device;

import java.util.HashMap;

/**
 * @author spikeF
 * @date 2020/9/4 16:37
 */
public class ObjectManage {
    /**
     * 档案信息
     */
    public HashMap<Integer, Device> archive = new HashMap<>();

    /**
     * 数据信息
     */
    public HashMap<Integer, Device> datas = new HashMap<>();
}
