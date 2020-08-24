package com.gdw;

import com.moon.util.ByteUtils;

/**
 * 地址域
 *
 * @author spike
 */
public class GdwProtocolAddress {

    /**
     * 获取行政区域
     *
     * @param data
     * @return
     */
    public static int getArea(byte[] data) throws Exception {
        return ByteUtils.fromBcd(data[1]) * 100 + ByteUtils.fromBcd(data[0]);
    }

    /**
     * 获取终端地址
     *
     * @param data
     * @return
     */
    public static int getAddress(byte[] data) {
        return ByteUtils.toInt(data, 2);
    }

    /**
     * 是否组地址
     *
     * @param data
     * @return
     */
    public static boolean isGroup(byte data) {
        return (data & 0x01) > 0;
    }

    /**
     * 获取组地址
     *
     * @param data
     * @return
     */
    public static int getMsa(byte data) {
        return data >> 1;
    }


    public static GdwProtocolAddress newInstance() {
        GdwProtocolAddress address = new GdwProtocolAddress();
        return address;
    }


    public static byte[] getAreaAddress(int areaAddress) {
        byte[] bytArea = new byte[2];
        bytArea[0] = (byte) ByteUtils.toBcd(areaAddress % 100);
        bytArea[1] = (byte) ByteUtils.toBcd(areaAddress / 100);
        return bytArea;
    }

    /**
     * 获取广播地址
     *
     * @return
     */
    public static byte[] getBroadcastTerminalAddress() {
        byte[] bytTerminal = new byte[2];
        bytTerminal[0] = (byte) 0xFF;
        bytTerminal[1] = (byte) 0xFF;
        return bytTerminal;
    }

    public static byte[] getTerminalAddress(int terminalAddress) {
        byte[] bytTerminal = new byte[2];
        bytTerminal[0] = (byte) (terminalAddress % 100);
        bytTerminal[1] = (byte) (terminalAddress / 100);
        return bytTerminal;
    }

    public static byte getMsa(int msa) throws Exception {
        return getMsa(false, msa);
    }

    public static byte getMsa(boolean fromTerminal, int msa) throws Exception {
        return getMsa(false, fromTerminal, msa);
    }

    public static byte getMsa(boolean isGroup, boolean fromTerminal, int msa) throws Exception {
        byte bytMsa = (byte) (isGroup ? 0x01 : 0x00);
        if (fromTerminal) {
            //终端启动发送帧的MSA应为零，其主站响应帧的MSA也应为零
            return bytMsa;
        }

        //主站启动的发送帧的MSA应为非零值
        if (msa == 0) {
            throw new Exception("主站启动的发送帧的MSA应为非零值");
        }
        bytMsa |= (msa << 1);
        return bytMsa;
    }
}
