package com.gdw.afn04;

import com.gdw.Afn;
import com.gdw.ProtocolItem;
import com.gdw.annotation.ItemAfn;

/**
 * 设置参数.
 */
@ItemAfn(Afn.PARAM_SET)
public abstract class AbstractAfn04 extends ProtocolItem {
    @Override
    public int decode(byte[] data, int offset) {
        return 0;
    }

    @Override
    public byte[] encode() {
        return new byte[0];
    }
}
