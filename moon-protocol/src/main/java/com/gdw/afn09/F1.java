package com.gdw.afn09;

/**
 * 终端版本信息
 */
public class F1 extends AbstractAfn09 {
    private String facotryAlias;
    private String deviceNo;
    private String softwareVersion;
    private String softwarePulishTime;
    private String capacityInfo;
    private String communicationNo;
    private String hardwareVersion;
    private String hardwarePulishTime;

    @Override
    public int decode(byte[] data, int offset) {

        return 4 + 8 + 4 + 3 + 11 + 4 + 4 + 3;
    }
}
