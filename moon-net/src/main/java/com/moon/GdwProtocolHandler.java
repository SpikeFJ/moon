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
                handleAfn00(ctx, msg);
                break;
            case Afn.RESET:
                handleAfn01(ctx, msg);
                break;
            case Afn.LINK_TEST:
                handleAfn02(ctx, msg);
                break;
            case Afn.RELAY_COMMAND:
                handleAfn03(ctx, msg);
                break;
            case Afn.PARAM_SET:
                handleAfn04(ctx, msg);
                break;
            case Afn.CONTROL_COMMAND:
                handleAfn05(ctx, msg);
                break;
            case Afn.AUTHENTICATION:
                handleAfn06(ctx, msg);
                break;
            case Afn.REQUEST_AUTOREPORT:
                handleAfn08(ctx, msg);
                break;
            case Afn.TERMINAL_CONFIG:
                handleAfn09(ctx, msg);
                break;
            case Afn.PARAM_QUERY:
                handleAfn0A(ctx, msg);
                break;
            case Afn.TASK_DATA_QUERY:
                handleAfn0B(ctx, msg);
                break;
            case Afn.CLS_ONE_QUERY:
                handleAfn0C(ctx, msg);
                break;
            case Afn.CLS_TWO_QUERY:
                handleAfn0D(ctx, msg);
                break;
            case Afn.CLS_THREE_QUERY:
                handleAfn0E(ctx, msg);
                break;
            case Afn.FILE_TRANSFER:
                handleAfn0F(ctx, msg);
                break;
            case Afn.DATA_TRANSMIT:
                handleAfn10(ctx, msg);
                break;
            default: {
                ctx.channel().close();
                logger.warn("未知的AFN:" + msg.getAfn() + ".");
            }
        }
    }


    private void handleAfn00(ChannelHandlerContext ctx, GdwProtocol msg) {

    }

    private void handleAfn01(ChannelHandlerContext ctx, GdwProtocol msg) {

    }

    private void handleAfn02(ChannelHandlerContext ctx, GdwProtocol msg) {

    }

    private void handleAfn03(ChannelHandlerContext ctx, GdwProtocol msg) {

    }

    private void handleAfn04(ChannelHandlerContext ctx, GdwProtocol msg) {

    }

    private void handleAfn05(ChannelHandlerContext ctx, GdwProtocol msg) {

    }

    private void handleAfn06(ChannelHandlerContext ctx, GdwProtocol msg) {

    }

    private void handleAfn08(ChannelHandlerContext ctx, GdwProtocol msg) {

    }

    private void handleAfn09(ChannelHandlerContext ctx, GdwProtocol msg) {

    }

    private void handleAfn0A(ChannelHandlerContext ctx, GdwProtocol msg) {

    }

    private void handleAfn0B(ChannelHandlerContext ctx, GdwProtocol msg) {

    }

    private void handleAfn0C(ChannelHandlerContext ctx, GdwProtocol msg) {

    }

    private void handleAfn0D(ChannelHandlerContext ctx, GdwProtocol msg) {

    }

    private void handleAfn0E(ChannelHandlerContext ctx, GdwProtocol msg) {

    }

    private void handleAfn0F(ChannelHandlerContext ctx, GdwProtocol msg) {

    }

    private void handleAfn10(ChannelHandlerContext ctx, GdwProtocol msg) {

    }
}
