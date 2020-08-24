package com.moon;

import com.gdw.GdwProtocol;
import com.gdw.GdwUtils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteOrder;

/**
 * Q/GDW　376.1—2009
 *
 * @author spike
 */
public class GdwProtocolDecoder extends LengthFieldBasedFrameDecoder {
    private static Logger logger = LoggerFactory.getLogger(GdwProtocolDecoder.class);

    private static int MAX_FRAME_LENGTH = 1024 * 8;
    /**
     * 因为起始字符是68H，68之后的两个字节表示长度，所以偏移一个68H
     */
    private static int LENGTH_FIELD_OFFSET = 1;

    /**
     * 68之后是2个字节L+2个字节L+68H，只需要解析一个长度L即可
     */
    private static int LENGTH_FIELD_LENGTH = 2;

    /**
     * 用户数据长度L1：由D2～D15组成，采用BIN编码，是控制域、地址域、链路用户数据（应用层）的字节总数。
     *
     * <p>
     * 所以LENGTH_ADJUSTMENT = L1 + 2（L1）+1(结束68H)+1（校验和）+1(结束字符16H)
     */
    private static int LENGTH_ADJUSTMENT = 5;

    public static GdwProtocolDecoder newGdwProtocolDecoder() {
        return new GdwProtocolDecoder(MAX_FRAME_LENGTH, LENGTH_FIELD_OFFSET, LENGTH_FIELD_LENGTH, LENGTH_ADJUSTMENT, 0);
    }


    public GdwProtocolDecoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength, int lengthAdjustment, int initialBytesToStrip) {
        super(MAX_FRAME_LENGTH, LENGTH_FIELD_OFFSET, LENGTH_FIELD_LENGTH, LENGTH_ADJUSTMENT, 0);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info(ByteBufUtil.hexDump((ByteBuf) msg));
        super.channelRead(ctx, msg);
    }

    /**
     * 计算长度
     *
     * @param buf
     * @param offset
     * @param length
     * @param order
     * @return
     */
    @Override
    protected long getUnadjustedFrameLength(ByteBuf buf, int offset, int length, ByteOrder order) {
        byte[] protocolBytes = new byte[2];
        buf.getBytes(offset, protocolBytes, 0, 2);
        return GdwUtils.getLength(protocolBytes);
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        ByteBuf data = ((ByteBuf) super.decode(ctx, in));
        if (data == null) {
            return null;
        }

        byte[] bytData = new byte[data.readableBytes()];
        data.readBytes(bytData, 0, bytData.length);
        in.release();

        try {
            GdwProtocol protocol = new GdwProtocol();
            //此处可以远程调用服务.即将所有规约做成规约服务,对外提供解帧、组帧两个接口
            protocol.decode(bytData);

            return protocol;
        } catch (Exception e) {
            logger.error("decode:" + e.getMessage());
            return null;
        }
    }
}
