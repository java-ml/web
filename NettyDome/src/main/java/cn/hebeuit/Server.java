package cn.hebeuit;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.CharsetUtil;


public class Server {
        public static void main(String[] args) {
                var bossGroup=new NioEventLoopGroup();
                EventLoopGroup workerGroup=new NioEventLoopGroup();
                ServerBootstrap bootstrap=new ServerBootstrap();
                bootstrap.group(bossGroup,workerGroup)
                        .channel(NioServerSocketChannel.class)
                        .option(ChannelOption.SO_BACKLOG,128)
                        .childOption(ChannelOption.SO_KEEPALIVE,true)
                        .childHandler(new ChannelInitializer<SocketChannel>() {
                                @Override
                                protected void initChannel(SocketChannel socketChannel) throws Exception {
                                        socketChannel.pipeline().addLast(
                                                new ChannelInboundHandlerAdapter(){
                                                        @Override
                                                        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                                                System.out.println(ctx);
                                                                ByteBuf buf=(ByteBuf)msg;
                                                                String s = buf.toString(CharsetUtil.UTF_8);
                                                                System.out.println(s);

                                                                ctx.writeAndFlush(Unpooled.copiedBuffer(s,CharsetUtil.UTF_8));
                                                        }

                                                        @Override
                                                        public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
                                                                ctx.writeAndFlush(Unpooled.copiedBuffer("end",CharsetUtil.UTF_8));

                                                        }

                                                    @Override
                                                    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
                                                        super.handlerRemoved(ctx);
                                                        System.out.println("out :"+ctx);

                                                    }
                                                }
                                        );
                                }
                        });
                try {
                        ChannelFuture cf=bootstrap.bind("127.0.0.1",6668).sync();
                        cf.channel().closeFuture().sync();
                } catch (Exception e) {
                        e.printStackTrace();

                }
        }


}
