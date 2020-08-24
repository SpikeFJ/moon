package com.gdw.afn01;

import com.gdw.Afn;
import com.gdw.annotation.ItemAfn;
import com.gdw.ProtocolItem;

/**
 * 复位命令（AFN=01H）.
 * 复位命令都是下行报文，上行报文都是确认/否认，所以子类无需实现decode方法
 *
 * @author spike
 */
@ItemAfn(Afn.RESET)
public abstract class AbstractAfn01 extends ProtocolItem {
    @Override
    public int decode(byte[] data, int offset) {
        return 0;
    }

    @Override
    public byte[] encode() {
        return new byte[0];
    }


}
