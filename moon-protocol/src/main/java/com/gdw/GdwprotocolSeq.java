package com.gdw;

import javax.sql.rowset.RowSetWarning;

/**
 * 帧序列号
 *
 * @author spike
 */
public class GdwprotocolSeq {
    private byte bytSeq;

    /**
     * TpV=0：表示在附加信息域中无时间标签Tp；
     * TpV=1：表示在附加信息域中带有时间标签Tp（Tp定义见本部分4.3.4.6.4）。
     *
     * @param data
     * @return
     */
    public static int getTpv(byte data) {
        return data >> 7;
    }

    /**
     * FIR：置“1”，报文的第一帧
     *
     * @param data
     * @return
     */
    public static int getFir(byte data) {
        return (data >> 6) & 0x01;
    }

    /**
     * FIN：置“1”，报文的最后一帧
     *
     * @param data
     * @return
     */
    public static int getFin(byte data) {
        return (data >> 5) & 0x01;
    }

    /**
     * FIR	FIN	应用说明
     * 0	0	多帧：中间帧
     * 0	1	多帧：结束帧
     * 1	0	多帧：第1帧，有后续帧。
     * 1	1	单帧
     *
     * @param data
     * @return
     */
    public static int getFirAndFin(byte data) {
        return (data & 0x7F) >> 4;
    }

    /**
     * 帧序列号
     *
     * @param data
     * @return
     */
    public static int getPseq(byte data) {
        return getRseq(data);
    }

    /**
     * @param data
     * @return
     */
    public static int getRseq(byte data) {
        return data & 0x0F;
    }


    public GdwprotocolSeq tpv(byte tpv) {
        this.bytSeq |= (tpv << 7);
        return this;
    }

    public GdwprotocolSeq firAndFin(byte firAndFin) {
        this.bytSeq |= (firAndFin << 5);
        return this;
    }


    public GdwprotocolSeq con(byte fcv) {
        this.bytSeq &= (fcv << 4);
        return this;
    }

    public GdwprotocolSeq pSeq(byte pSeq) {
        return rSeq(pSeq);
    }

    public GdwprotocolSeq rSeq(byte rSeq) {
        this.bytSeq &= rSeq;
        return this;
    }

    public byte getSeq() {
        return this.bytSeq;
    }
}
