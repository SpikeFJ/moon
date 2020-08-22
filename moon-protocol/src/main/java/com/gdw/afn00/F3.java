package com.gdw.afn00;

import com.gdw.annotation.Item;

import java.util.List;

/**
 * 按数据单元标识确认和否认
 */
@Item(name = "按数据单元标识确认和否认", fn = 2)
public class F3 extends AbstractAfn00 {
    public int afn;
    public List<F3Body> bodyList;

    @Override

    public int decode(byte[] data, int offset) {
        return super.decode(data, offset);
    }
}
