package com.gdw.afn0D;

import com.gdw.Afn;
import com.gdw.ProtocolItem;
import com.gdw.annotation.ItemAfn;

/**
 * 日冻结类数据时标
 *
 * @author spike
 */
@ItemAfn(Afn.CLS_TWO_QUERY)
public abstract class AbstractAfn0D_Td_d extends ProtocolItem {
    protected String time;


    @Override
    public int decode(byte[] data, int offset) {
        //5个字节

        int bodyLength = decodeBody(data, offset + 7);
        return 3 + bodyLength;
    }

    protected abstract int decodeBody(byte[] data, int startIndex);
}
