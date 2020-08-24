package com.gdw.afn02;

import com.gdw.Afn;
import com.gdw.ProtocolItem;
import com.gdw.annotation.ItemAfn;

/**
 * 链路接口检测.
 *
 * <p>
 * 只有上行报文，下行报文即确认/否认帧
 * </p>
 */
@ItemAfn(Afn.LINK_TEST)
public abstract class AbstractAfn02 extends ProtocolItem {
    @Override
    public int decode(byte[] data, int offset) {
        return 0;
    }

    @Override
    public byte[] encode() {
        return new byte[0];
    }
}
