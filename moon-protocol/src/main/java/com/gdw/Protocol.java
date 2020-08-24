package com.gdw;

import java.util.List;

/**
 * 通讯规约
 *
 * @author spike
 */
public interface Protocol {

    /**
     * 规约名称
     *
     * @return
     */
    String name();

    /**
     * 规约描述
     *
     * @return
     */
    String description();

    /**
     * 解帧
     *
     * @param data
     * @return
     */
    void decode(byte[] data) throws Exception;

    /**
     * 组帧
     *
     * @return
     */
    byte[] encode();

}
