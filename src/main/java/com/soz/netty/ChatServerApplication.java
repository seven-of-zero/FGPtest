package com.soz.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ChatServerApplication {

    @Autowired
    @Qualifier("bootstrap")
    private ServerBootstrap serverBootstrap;

    private Channel channel;

    public void start() throws Exception {
        System.out.println("netty启动");
        serverBootstrap.bind(8888).sync().channel().closeFuture().sync().channel();
    }

    public void close(){
        channel.close();
        channel.parent().close();
    }

}
