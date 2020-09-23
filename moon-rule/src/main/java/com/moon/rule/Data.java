package com.moon.rule;

import com.moon.entity.Device;
import com.moon.rule.annotation.ExportProperty;
import com.moon.rule.annotation.TopicFor;

/**
 * 要监测的项是和具体的业务对象绑定的。
 * <p>
 * 至于是瞬时数据，还是过程数据，则是用户在页面选定的；
 * 如果选择过程数据，还需要指明 多长时间/多长频率，如连续3小时，连续2天
 * <p>
 * <p>
 * 当用户选择了要关注的数据字段，
 * >XX
 * <XX
 * !=XX 这些应该就是Condition，即who参与condition对象的evaluate,
 * <p>
 * 即 谁(温度、湿度) 小于/大于(比较符) 基准值，组成了Condition
 * <p>
 * 那么Message格式就应该确定
 *
 * @author spikeF
 * @date 2020/9/4 16:38
 */
@TopicFor(Device.class)
public class Data {

    @ExportProperty(label = "温度", name = "tmpa", topic = "tmpAndOther")
    private int tmpA;

    @ExportProperty(label = "湿度", name = "tmpb", topic = "tmpAndOther")
    public String tmpB;

    @ExportProperty(label = "速度", name = "speedc", topic = "speed")
    public String speedC;

}
