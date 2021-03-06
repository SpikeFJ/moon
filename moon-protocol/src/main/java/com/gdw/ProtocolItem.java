package com.gdw;

/**
 * 规约项
 *
 * @author spike
 */
public abstract class ProtocolItem {
    private Protocol protocol;

    private int da;
    private int dt;

    public abstract int decode(byte[] data, int offset);

    public abstract byte[] encode();

    public void setDt(int dt) {
        this.dt = dt;
    }

    public void setDa(int da) {
        this.da = da;
    }

    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }
}
