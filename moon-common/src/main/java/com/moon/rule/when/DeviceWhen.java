package com.moon.rule.when;

import com.moon.rule.When;

/**
 *
 * when是用于trigger配置的，界面选择了when，trigger监听对应的topic
 *
 * @author spikeF
 * @date 2020/9/7 15:17
 */
public class DeviceWhen {

    public When deviceArchiveChanged = new When() {

        @Override
        public String topic() {
            return "DeviceArchiveChanged";
        }

        @Override
        public String desc() {
            return "当设备变更时";
        }
    };
}
