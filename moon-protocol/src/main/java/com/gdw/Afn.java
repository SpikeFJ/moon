package com.gdw;

/**
 * 应用层功能码
 * @author spike
 */
public class Afn {

    /**
     * 确认/否认
     */
    public static final int YESNO = 0x00;

    /**
     * 复位
     */
    public static final int RESET = 0x01;

    /**
     * 链路测试
     */
    public static final int LINK_TEST = 0x02;

    /*
     * 中继站命令
     */
    public static final int RELAY_COMMAND = 0x03;

    /**
     * 设置参数
     */
    public static final int PARAM_SET = 0x04;

    /**
     * 控制命令
     */
    public static final int CONTROL_COMMAND = 0x05;

    /**
     * 身份认证
     */
    public static final int AUTHENTICATION = 0x06;

    /**
     * 请求被级联终端主动上报
     */
    public static final int REQUEST_AUTOREPORT = 0x08;

    /**
     * 终端配置
     */
    public static final int TERMINAL_CONFIG = 0x09;

    /**
     * 查询参数
     */
    public static final int PARAM_QUERY = 0x0A;

    /**
     * 任务数据查询
     */
    public static final int TASK_DATA_QUERY = 0x0B;

    /**
     * 请求1类数据（实时数据）
     */
    public static final int CLS_ONE_QUERY = 0x0C;

    /**
     * 请求2类数据（历史数据）
     */
    public static final int CLS_TWO_QUERY = 0x0D;

    /**
     * 请求3类数据（事件数据）
     */
    public static final int CLS_THREE_QUERY = 0x0E;

    /**
     * 文件传输
     */
    public static final int FILE_TRANSFER = 0x0F;

    /**
     * 数据转发
     */
    public static final int DATA_TRANSMIT = 0x10;

    public static int getCode() {
        return 0;
    }

    private static String getName() {
        return "";
    }

    /**
     * 是否包含事件计数器EC(上行)
     *
     * @param afn
     * @return
     */
    public static boolean haveEc(int afn) {
        return afn == Afn.RESET || afn == Afn.PARAM_SET || afn == Afn.CONTROL_COMMAND || afn == Afn.DATA_TRANSMIT || afn == Afn.FILE_TRANSFER;
    }

    /**
     * 是否包含消息认证PW(下行)
     *
     * @param afn
     * @return
     */
    public static boolean havePw(int afn) {
        return afn == Afn.RESET || afn == Afn.PARAM_SET || afn == Afn.CONTROL_COMMAND || afn == Afn.DATA_TRANSMIT || afn == Afn.FILE_TRANSFER;
    }
}
