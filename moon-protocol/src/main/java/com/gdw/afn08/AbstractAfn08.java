package com.gdw.afn08;

import com.gdw.Afn;
import com.gdw.ProtocolItem;
import com.gdw.annotation.ItemAfn;

/**
 * 请求被级联终端主动上报.
 *
 * @author spike
 */
@ItemAfn(Afn.LINK_TEST)
public abstract class AbstractAfn08 extends ProtocolItem {
    @Override
    public int decode(byte[] data, int offset) {
        return 0;
    }

    @Override
    public byte[] encode() {
        return new byte[0];
    }
}
