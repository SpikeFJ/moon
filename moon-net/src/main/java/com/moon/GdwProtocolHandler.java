package com.moon;

import com.gdw.Afn;
import com.gdw.GdwProtocol;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 处理Gdw事件
 *
 * @author spike
 */
public class GdwProtocolHandler extends SimpleChannelInboundHandler<GdwProtocol> {
    Logger logger = LoggerFactory.getLogger(GdwProtocolHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GdwProtocol msg) throws Exception {
        logger.info(String.valueOf(msg.getAfn()));
        switch (msg.getAfn()) {
            case Afn.YESNO:
                break;
            case Afn.RESET:
                break;
            case Afn.LINK_TEST:
                break;
            case Afn.RELAY_COMMAND:
                break;
            case Afn.PARAM_SET:
                break;
            case Afn.CONTROL_COMMAND:
                break;
            case Afn.AUTHENTICATION:
                break;
            case Afn.REQUEST_AUTOREPORT:
                break;
            case Afn.TERMINAL_CONFIG:
                break;
            case Afn.PARAM_QUERY:
                break;
            case Afn.TASK_DATA_QUERY:
                break;
            case Afn.CLS_ONE_QUERY:
                break;
            case Afn.CLS_TWO_QUERY:
                break;
            case Afn.CLS_THREE_QUERY:
                break;
            case Afn.FILE_TRANSFER:
                break;
            case Afn.DATA_TRANSMIT:
                break;
            default: {
            }
        }
    }
}
