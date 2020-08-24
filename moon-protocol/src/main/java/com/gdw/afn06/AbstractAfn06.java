package com.gdw.afn06;

import com.gdw.Afn;
import com.gdw.ProtocolItem;
import com.gdw.annotation.ItemAfn;

/**
 * 身份认证及密钥协商.
 *
 * @author spike
 */
@ItemAfn(Afn.AUTHENTICATION)
public abstract class AbstractAfn06 extends ProtocolItem {
    @Override
    public int decode(byte[] data, int offset) {
        return 0;
    }

    @Override
    public byte[] encode() {
        return new byte[0];
    }
}
