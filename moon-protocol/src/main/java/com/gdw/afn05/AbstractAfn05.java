package com.gdw.afn05;

import com.gdw.Afn;
import com.gdw.ProtocolItem;
import com.gdw.annotation.ItemAfn;

/**
 * 控制命令.
 *
 * @author spike
 */
@ItemAfn(Afn.CONTROL_COMMAND)
public abstract class AbstractAfn05 extends ProtocolItem {
    @Override
    public int decode(byte[] data, int offset) {
        return 0;
    }

    @Override
    public byte[] encode() {
        return new byte[0];
    }
}
