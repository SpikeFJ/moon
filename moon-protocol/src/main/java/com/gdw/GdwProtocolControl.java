package com.gdw;

/**
 * 控制域
 *
 * @author spike
 */
public class GdwProtocolControl {
    private byte bytControl;

    /**
     * 传输方向位. 0：主站发出的下行报文 1：终端发出的上行报文
     *
     * @param data
     * @return
     */
    public static int getDir(byte data) {
        return data >> 7;
    }

    /**
     * 启动标志位.0:来自从动站 1：来自启动站
     *
     * @param data
     * @return
     */
    public static int getPrm(byte data) {
        return (data >> 6) & 0x01;
    }

    /**
     * 当帧计数有效位FCV=1时，FCB表示每个站连续的发送/确认或者请求/响应服务的变化位
     * 启动站向同一从动站传输新的发送/确认或请求/响应传输服务时，将FCB取相反值
     * 启动站保存每一个从动站FCB值，若超时未收到从动站的报文，或接收出现差错，则启动站不改变FCB的状态
     *
     * @param data
     * @return
     */
    public static int getFcb(byte data) {
        return getAcd(data);
    }

    /**
     * 帧计数有效位。0：FCB位无效 1：FCB位有效
     *
     * @param data
     * @return
     */
    public static int getFcv(byte data) {
        return (data >> 4) & 0x01;
    }

    /**
     * ACD=1表示终端有重要事件等待访问，则附加信息域中带有事件计数器EC
     * ACD=0表示终端无事件数据等待访问
     *
     * @param data
     * @return
     */
    public static int getAcd(byte data) {
        return (data >> 5) & 0x01;
    }

    /**
     * 功能码
     *
     * @param data
     * @return
     */
    public static int getFunc(byte data) {
        return data & 0x0F;
    }


    public static GdwProtocolControl newInstance() {
        GdwProtocolControl control = new GdwProtocolControl();
        return control;
    }

    public GdwProtocolControl dir(int dir) {
        this.bytControl |= (dir << 7);
        return this;
    }

    public GdwProtocolControl prm(int prm) {
        this.bytControl |= (prm << 6);
        return this;
    }

    public GdwProtocolControl fcb(int fcb) {
        return acd(fcb);
    }

    public GdwProtocolControl fcv(int fcv) {
        this.bytControl &= (fcv << 4);
        return this;
    }

    public GdwProtocolControl acd(int fcv) {
        this.bytControl &= (fcv << 5);
        return this;
    }

    public GdwProtocolControl func(int func) {
        this.bytControl &= func;
        return this;
    }

    public byte getControl() {
        return this.bytControl;
    }
}
