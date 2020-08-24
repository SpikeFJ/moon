package com.gdw.afn0D;

import com.gdw.Afn;
import com.gdw.ProtocolItem;
import com.gdw.annotation.ItemAfn;

/**
 * 曲线类数据
 *
 * @author spike
 */
@ItemAfn(Afn.CLS_TWO_QUERY)
public abstract class AbstractAfn0D_Td_c extends ProtocolItem {
    protected String time;
    protected int density;
    protected int pointNum;


    @Override
    public int decode(byte[] data, int offset) {
        //5个字节
        //1个字节密度
        //1个字节点数
        decodeBody(data, offset + 7);

        return 5 + 1 + 1 + pointNum;
    }

    protected abstract void decodeBody(byte[] data, int startIndex);
}
