package com.gdw.afn09;

import com.gdw.Afn;
import com.gdw.ProtocolItem;
import com.gdw.annotation.ItemAfn;

/**
 * 请求终端配置及信息.
 *
 * @author spike
 */
@ItemAfn(Afn.TERMINAL_CONFIG)
public abstract class AbstractAfn09 extends ProtocolItem {
    @Override
    public int decode(byte[] data, int offset) {
        return 0;
    }

    @Override
    public byte[] encode() {
        return new byte[0];
    }
}
