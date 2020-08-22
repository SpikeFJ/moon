package com.gdw;

/**
 * Gdw规约帮助类
 *
 * @author spike
 */
public class GdwUtils {

    public static int getDa(byte[] value, int offset) {
        byte byDa1 = value[offset];
        byte byDa2 = value[offset + 1];

        if (byDa1 == 0 && byDa2 == 0) {
            return 0;
        }

        int pn = (byDa2 - 1) * 8;
        for (int i = 0; i < 8; i++) {
            if (((byDa1 >> i) & 0x01) > 0) {
                pn += (i + 1);
                break;
            }
        }
        return pn;
    }

    public static int getDt(byte[] value, int offset) {
        byte byDt1 = value[offset];
        byte byDt2 = value[offset + 1];


        int fn = byDt2 * 8;
        for (int i = 0; i < 8; i++) {
            if (((byDt1 >> i) & 0x01) > 0) {
                fn += (i + 1);
                break;
            }
        }
        return fn;
    }

    public static int getLength(byte[] protocolBytes) {
        if (protocolBytes == null || protocolBytes.length < 2) {
            return -1;
        }
        return (protocolBytes[1] << 8) + (protocolBytes[0] >> 2);
    }

    public static void checkLength(int length, int minLength) throws Exception {
        if (length < minLength) {
            throw new Exception("length长度不足" + minLength + ":" + length);
        }
    }

    public static void checkByte(byte data, byte expected) throws Exception {
        if (data != expected) {
            throw new Exception("期望：" + expected + ",实际：" + data);
        }
    }

    public static int calcCs(byte[] data, int endIndex) {
        //从控制域开始
        byte bytSum = 0;
        for (int i = 6; i < endIndex; i++) {
            bytSum += data[i];
        }
        return bytSum;
    }

}
