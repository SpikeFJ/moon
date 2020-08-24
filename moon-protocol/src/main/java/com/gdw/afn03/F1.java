package com.gdw.afn03;

import com.gdw.afn01.AbstractAfn01;
import com.gdw.annotation.Item;

/**
 * 中继站工作状态控制
 */
@Item(name = "中继站工作状态控制", fn = 1)
public class F1 extends AbstractAfn01 {
//    /**
//     * 值班机/备份机切换控制。0：不切换， 3：切换， 其他无效
//     */
//    private int masterSlaveControl;
//
//    /**
//     * 值班机中继转发允许标志。0：不允许， 3：允许， 其他无效
//     */
//    private int allowdispathControl;

    private WorkStatus stationA;
    private WorkStatus stationB;

    @Override
    public int decode(byte[] data, int offset) {

        byte tmp = data[offset];
        stationA = new WorkStatus(tmp & 0x0F);
        stationB = new WorkStatus((tmp & 0xF0) >> 4);
        return 1;
    }
//
//    private void encode()
//    {
//        byte tmp = data[offset];
//
//        masterSlaveControl = tmp & 0x03;
//        allowdispathControl = (tmp >> 2) & 0x03;
//
//        return 1;
//    }
}


/**
 * 当前中继站工作状态
 */
class WorkStatus {

    public WorkStatus(int value) {
        status = value & 0x03;
        masterOrBackup = (value >> 2) & 0x01;
        allowDispatch = (value >> 3) & 0x01;
    }

    /**
     * 0：不存在，1：正常，2：故障，3：备用
     */
    private int status;
    /**
     * 0:备份机，1：值班机
     */
    private int masterOrBackup;

    /**
     * 0:禁止中继转发 1:允许中继转发
     */
    private int allowDispatch;


}