package com.moon.util;

/**
 * 字节转换工具类
 */
public class ByteUtils {
    //     * 所谓BCD就是将10进制的数据转换为显示相同的16进制数据
    //     * eg:数字68的BCD就是0x\68,即104=6*16+8

    /**
     * 是否BCD码
     *
     * @param value
     * @return
     */
    public static boolean isBcd(byte value) {
        if ((value >> 4) > 9) {
            return false;
        }
        if ((value & 0x0F) > 9) {
            return false;
        }
        return true;
    }

    /**
     * bin转换成BCD
     *
     * @param value
     * @return
     */
    public static int toBcd(int value) {
        return ((value / 10) * 16 + value % 10);
    }


    /**
     * BCD码转换成bin
     *
     * @param value
     * @return
     */
    public static int fromBcd(byte value) throws Exception {
        if (isBcd(value)) {
            throw new Exception(value + "不是BCD码");
        }
        return (value >> 4) * 10 + (value & 0x0F);
    }

    public static int toInt(byte[] value) {
        return toInt(value);
    }

    public static int toInt(byte[] value, int offset) {
        return value[offset + 3] << 32 + value[offset + 3] << 16 + value[offset + 1] << 8 + value[offset];
    }

    /**
     * 获取16进制显示
     *
     * @param value
     * @return
     */
    public static String outHex(byte value) {
        return Integer.toString(value, 16);
    }

    /**
     * 获取16进制显示
     *
     * @param value
     * @return
     */
    public static String outHex(byte[] value) {
        StringBuilder sb = new StringBuilder();
        for (byte b : value) {
            sb.append(b);
            sb.append("");
        }
        return sb.toString();
    }

}
