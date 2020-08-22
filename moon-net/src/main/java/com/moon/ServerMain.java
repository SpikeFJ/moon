package com.moon;

import com.gdw.GdwProtocol;
import com.sun.corba.se.internal.CosNaming.BootstrapServer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LoggingHandler;

public class ServerMain {

    private NioEventLoopGroup boss = new NioEventLoopGroup();
    private NioEventLoopGroup work = new NioEventLoopGroup();


    public static void main(String[] args) throws InterruptedException {
        ServerMain serverMain = new ServerMain();
        serverMain.start();

    }

    private void start() throws InterruptedException {
        final ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(boss, work)
                .channel(NioServerSocketChannel.class)
                .handler(new LoggingHandler())
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        pipeline.addLast(GdwProtocolDecoder.newGdwProtocolDecoder());
                        pipeline.addLast(new GdwProtocolHandler());
                    }
                });

        ChannelFuture sync = serverBootstrap.bind(30001).sync();
    }
}

