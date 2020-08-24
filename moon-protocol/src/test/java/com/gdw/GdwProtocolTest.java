package com.gdw;

import org.junit.Test;

import static org.junit.Assert.*;

public class GdwProtocolTest {

    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }


    @Test
    public void decode() throws Exception {
        byte[] byt = new byte[0];

        GdwProtocol protocol = new GdwProtocol();
        protocol.decode(byt);
    }

    @Test
    public void encode() {
        GdwProtocol protocol = new GdwProtocol();
        int dir = 1;
        protocol.setControlCode(GdwProtocolControl
                .newInstance()
                .dir(1)
                .fcb(1)
                .acd(0)
                .fcv(1)
                .func(11).getControl());

        protocol.setAreaAddress(2301);
        protocol.setTerminalAddress(1);
        protocol.setAddressFlag((byte) 1);

        byte[] encoded = protocol.encode();
    }
}