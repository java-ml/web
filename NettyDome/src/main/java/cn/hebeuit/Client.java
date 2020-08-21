package cn.hebeuit;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

public class Client {
    public static void main(String[] args) {
        EventLoopGroup eventExecutors=new NioEventLoopGroup();
        Bootstrap bootstrap=new Bootstrap();
        bootstrap.group(eventExecutors)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    protected void initChannel(SocketChannel serverChannel) throws Exception {
                        serverChannel.pipeline().addLast(
                                new ChannelInboundHandlerAdapter(){
                                    @Override
                                    public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                        System.out.println(ctx);
                                        ctx.writeAndFlush(Unpooled.copiedBuffer("hello", CharsetUtil.UTF_8));
                                    }

                                    @Override
                                    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                        System.out.println("read:"+ctx);
                                        ByteBuf buf=(ByteBuf)msg;
                                        System.out.println(buf.toString(CharsetUtil.UTF_8));

                                    }
                                }
                        );
                    }
                });
        try {

            ChannelFuture channelFuture= bootstrap.connect("127.0.0.1",6668).sync();
            Thread.sleep(10000);
            channelFuture.channel().writeAndFlush(Unpooled.copiedBuffer("hi", CharsetUtil.UTF_8));
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            eventExecutors.shutdownGracefully();

        }

    }
}
