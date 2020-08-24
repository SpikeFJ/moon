package com.gdw.afn03;

import com.gdw.Afn;
import com.gdw.ProtocolItem;
import com.gdw.annotation.ItemAfn;

/**
 * 中继站命令.
 */
@ItemAfn(Afn.RELAY_COMMAND)
public abstract  class AbstractAfn03 extends ProtocolItem {
    @Override
    public int decode(byte[] data, int offset) {
        return 0;
    }

    @Override
    public byte[] encode() {
        return new byte[0];
    }
}
