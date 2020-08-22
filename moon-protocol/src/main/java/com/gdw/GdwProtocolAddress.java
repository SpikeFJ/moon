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
    public static String getArea(byte[] data) {
        return String.valueOf(ByteUtils.fromBcd(data[1])) + String.valueOf(ByteUtils.fromBcd(data[0]));
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

}
