package com.gdw.afn00;

import com.gdw.Afn;
import com.gdw.annotation.ItemAfn;
import com.gdw.ProtocolItem;

/**
 * 确认∕否认（AFN=00H）
 *
 * @author spike
 */
@ItemAfn(Afn.YESNO)
public abstract class AbstractAfn00 extends ProtocolItem {

    @Override
    public int decode(byte[] data, int offset) {
        return 0;
    }

    @Override
    public byte[] encode() {
        return new byte[0];
    }
}
