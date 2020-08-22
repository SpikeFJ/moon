package com.gdw.afn01;

import com.gdw.Afn;
import com.gdw.annotation.ItemAfn;
import com.gdw.ProtocolItem;

/**
 * 复位命令（AFN=01H
 *
 * @author spike
 */
@ItemAfn(Afn.RESET)
public abstract class AbstractAfn01 extends ProtocolItem {
    @Override
    public int decode(byte[] data, int offset) {
        return 0;
    }
}
