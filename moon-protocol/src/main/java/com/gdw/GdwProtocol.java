package com.gdw;

import java.util.List;

import static com.gdw.GdwUtils.*;

/**
 * GDW2009规约
 *
 * @author spike
 */
public class GdwProtocol implements Protocol {

    private static class Decoder {

    }

    private static class Encoder {

    }


    /**
     * 固定包头
     */
    private static byte PACKET_HEAD = 0x68;

    /**
     * 固定包尾
     */
    private static byte PACKET_TAIL = 0x16;

    /**
     * 规约标识
     */
    private int protoclIdentify;

    /**
     * 规约长度
     */
    private int protocolLength;

    /**
     * 控制码
     */
    private byte controlCode;

    /**
     * 行政区划码。
     */
    private int areaAddress;

    /**
     * 终端地址,选址范围为1～65535。0000H为无效地址，FFFFH且<ref>addressFlag</ref>的D0位为“1”时表示系统广播地址
     */
    private int terminalAddress;

    /**
     * 主站地址和组地址标志
     * D0=0表示终端地址A2为单地址,D0=1表示终端地址A2为组地址,D1～D7组成0～127个主站地址MSA
     * 主站启动的发送帧的MSA应为非零值，其终端响应帧的MSA应与主站发送帧的MSA相同
     * 终端启动发送帧的MSA应为零，其主站响应帧的MSA也应为零
     */
    private byte addressFlag;

    /**
     * 应用层功能码
     */
    private int afn;

    /**
     * 帧序列域
     */
    private byte seq;

    /**
     * 数据项
     */
    ProtocolItemCollection items;

    /**
     * 重要事件计数器
     */
    private int ec1;
    /**
     * 一般事件计数器
     */
    private int ec2;


    /**
     * 启动帧帧序号计数器
     */
    private int pfc;

    /**
     * 启动帧发送时标
     */
    private int day;
    private int hour;
    private int minute;
    private int second;


    /**
     * 允许发送传输延时时间.单位：分钟
     */
    private int allowDelay;


    /**
     * 帧校验和
     */
    private int cs;

    public String name() {
        return null;
    }

    public String description() {
        return null;
    }

    public void decode(byte[] data) throws Exception {
        checkLength(data.length, 12);
        int offset = 0;

        checkByte(data[offset++], PACKET_HEAD);

        byte[] bytProtocol = new byte[2];
        System.arraycopy(data, offset, bytProtocol, 0, 2);
        protoclIdentify = bytProtocol[0] & 0x02;
        protocolLength = getLength(bytProtocol);
        offset += 4;

        checkByte(data[offset++], PACKET_HEAD);

        controlCode = data[offset++];

        areaAddress = GdwProtocolAddress.getArea(data);
        offset += 2;

        terminalAddress = GdwProtocolAddress.getAddress(data);
        offset += 2;

        addressFlag = data[offset++];

        afn = data[offset++];
        seq = data[offset++];

        byte[] userData = new byte[protocolLength];
        System.arraycopy(data, offset, userData, 0, userData.length);

        offset += decodeUserData(data, offset);


        if (GdwProtocolControl.getAcd(controlCode) == 1) {
            ec1 = data[offset++];
            ec2 = data[offset++];
        }

        if (GdwprotocolSeq.getTpv(seq) == 1) {
            pfc = data[offset++];
            second = data[offset++];
            minute = data[offset++];
            hour = data[offset++];
            day = data[offset++];
            allowDelay = data[offset++];
        }

        byte calcSum = (byte) calcCs(data, offset);
        byte cs = data[offset++];

        checkByte(calcSum, cs);
        checkByte(data[offset], PACKET_TAIL);
    }

    /**
     * @param data
     * @param data
     * @param startIndex
     * @return 用户数据的长度
     */
    protected int decodeUserData(byte[] data, int startIndex) {

        int offset = 0;

        while (startIndex + offset < data.length) {
            int pn = getDa(data, startIndex + offset);
            offset += 2;

            int fn = getDt(data, startIndex + offset);
            offset += 2;

            ProtocolItem item = ProtocolItemManage.getItem(this.afn, fn);
            item.setDa(pn);
            item.setDt(fn);
            item.setProtocol(this);

            offset += item.decode(data, startIndex + offset);

            items.add(item);
        }

        return offset;
    }

    public byte[] encode() {
        //判断附加信息域中是否包含密码PW/EC、时间标签Tp
        boolean havePw = Afn.haveEc(afn);
        int pwLength = havePw ? (this.protoclIdentify < 3 ? 2 : 16) : 0;
        byte[] userData = items.encode();
        int totalLength = ((userData.length + pwLength + 8) << 2) + this.protoclIdentify;

        int offset = 0;
        byte[] value = new byte[16 + userData.length + pwLength];
        value[offset++] = PACKET_HEAD;
        value[offset++] = (byte) (totalLength % 256);
        value[offset++] = (byte) (totalLength / 256);
        value[offset++] = (byte) (totalLength % 256);
        value[offset++] = (byte) (totalLength / 256);
        value[offset++] = PACKET_HEAD;

        value[offset++] = (byte) controlCode;

        byte[] bytAreaAddress = GdwProtocolAddress.getAreaAddress(this.areaAddress);
        System.arraycopy(bytAreaAddress, 0, value, offset, bytAreaAddress.length);
        offset += 2;

        byte[] bytTerminalAddress = GdwProtocolAddress.getTerminalAddress(this.terminalAddress);
        System.arraycopy(bytTerminalAddress, 0, value, offset, bytTerminalAddress.length);
        offset += 2;

        value[offset++] = addressFlag;

        value[offset++] = (byte) afn;
        value[offset++] = seq;

        System.arraycopy(userData, 0, value, offset, userData.length);
        offset += userData.length;


        if (GdwProtocolControl.getDir(controlCode) == 0) {
            if (Afn.havePw(afn)) {
                //下行
                byte[] bytPw = new byte[16];

                System.arraycopy(bytPw, 0, value, offset, bytPw.length);
                offset += bytPw.length;
            }
        } else {
            //上行
            value[offset++] = (byte) ec1;
            value[offset++] = (byte) ec2;
        }

        if (GdwprotocolSeq.getTpv(seq) == 1) {
            //时间标签
            value[offset++] = (byte) pfc;

            byte[] bytTime = GdwUtils.encodeA16(day, hour, minute, second);
            System.arraycopy(bytTime, 0, value, offset, bytTime.length);
            offset += bytTime.length;

            value[offset++] = (byte) allowDelay;
        }
        byte calcSum = (byte) calcCs(value, offset);
        value[offset++] = calcSum;
        value[offset++] = PACKET_TAIL;
        return value;
    }

    protected byte[] encodeUserData() {
        return new byte[0];
    }

    public int getProtoclIdentify() {
        return protoclIdentify;
    }

    public void setProtoclIdentify(int protoclIdentify) {
        this.protoclIdentify = protoclIdentify;
    }

    public int getProtocolLength() {
        return protocolLength;
    }

    public void setProtocolLength(int protocolLength) {
        this.protocolLength = protocolLength;
    }

    public byte getControlCode() {
        return controlCode;
    }

    public void setControlCode(byte controlCode) {
        this.controlCode = controlCode;
    }

    public int getAreaAddress() {
        return areaAddress;
    }

    public void setAreaAddress(int areaAddress) {
        this.areaAddress = areaAddress;
    }

    public int getTerminalAddress() {
        return terminalAddress;
    }

    public void setTerminalAddress(int terminalAddress) {
        this.terminalAddress = terminalAddress;
    }

    public byte getAddressFlag() {
        return addressFlag;
    }

    public void setAddressFlag(byte addressFlag) {
        this.addressFlag = addressFlag;
    }

    public int getAfn() {
        return afn;
    }

    public void setAfn(int afn) {
        this.afn = afn;
    }

    public byte getSeq() {
        return seq;
    }

    public void setSeq(byte seq) {
        this.seq = seq;
    }

    public ProtocolItemCollection getResult() {
        return items;
    }

    public void setResult(ProtocolItemCollection result) {
        this.items = result;
    }

    public int getEc1() {
        return ec1;
    }

    public void setEc1(int ec1) {
        this.ec1 = ec1;
    }

    public int getEc2() {
        return ec2;
    }

    public void setEc2(int ec2) {
        this.ec2 = ec2;
    }

    public int getPfc() {
        return pfc;
    }

    public void setPfc(int pfc) {
        this.pfc = pfc;
    }

    public String getSendTimeStamp() {
        return day + "日" + hour + ":" + minute + ":" + second;
    }

    public int getAllowDelay() {
        return allowDelay;
    }

    public void setAllowDelay(int allowDelay) {
        this.allowDelay = allowDelay;
    }

    public int getCs() {
        return cs;
    }

    public void setCs(int cs) {
        this.cs = cs;
    }
}
