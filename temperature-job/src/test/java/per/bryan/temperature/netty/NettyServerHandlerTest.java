package per.bryan.temperature.netty;

import java.net.SocketAddress;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.*;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.EventExecutor;
import per.bryan.temperature.CommandLineApp;
import per.bryan.temperature.NettyApplication;

/**
 * @Author:bryan.c
 * @Date:2020/11/3
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = NettyApplication.class)
class NettyServerHandlerTest {
    @MockBean
    private CommandLineApp commandLineApp;
    @Autowired
    private NettyServerHandler nettyServerHandler;

    @Test
    void channelRead() throws Exception {
        ChannelHandlerContext channelHandlerContext = new ChannelHandlerContext() {
            @Override
            public Channel channel() {
                return null;
            }

            @Override
            public EventExecutor executor() {
                return null;
            }

            @Override
            public String name() {
                return null;
            }

            @Override
            public ChannelHandler handler() {
                return null;
            }

            @Override
            public boolean isRemoved() {
                return false;
            }

            @Override
            public ChannelHandlerContext fireChannelRegistered() {
                return null;
            }

            @Override
            public ChannelHandlerContext fireChannelUnregistered() {
                return null;
            }

            @Override
            public ChannelHandlerContext fireChannelActive() {
                return null;
            }

            @Override
            public ChannelHandlerContext fireChannelInactive() {
                return null;
            }

            @Override
            public ChannelHandlerContext fireExceptionCaught(Throwable cause) {
                return null;
            }

            @Override
            public ChannelHandlerContext fireUserEventTriggered(Object evt) {
                return null;
            }

            @Override
            public ChannelHandlerContext fireChannelRead(Object msg) {
                return null;
            }

            @Override
            public ChannelHandlerContext fireChannelReadComplete() {
                return null;
            }

            @Override
            public ChannelHandlerContext fireChannelWritabilityChanged() {
                return null;
            }

            @Override
            public ChannelHandlerContext read() {
                return null;
            }

            @Override
            public ChannelHandlerContext flush() {
                return null;
            }

            @Override
            public ChannelPipeline pipeline() {
                return null;
            }

            @Override
            public ByteBufAllocator alloc() {
                return null;
            }

            @Override
            public <T> Attribute<T> attr(AttributeKey<T> key) {
                return null;
            }

            @Override
            public <T> boolean hasAttr(AttributeKey<T> key) {
                return false;
            }

            @Override
            public ChannelFuture bind(SocketAddress localAddress) {
                return null;
            }

            @Override
            public ChannelFuture connect(SocketAddress remoteAddress) {
                return null;
            }

            @Override
            public ChannelFuture connect(SocketAddress remoteAddress, SocketAddress localAddress) {
                return null;
            }

            @Override
            public ChannelFuture disconnect() {
                return null;
            }

            @Override
            public ChannelFuture close() {
                return null;
            }

            @Override
            public ChannelFuture deregister() {
                return null;
            }

            @Override
            public ChannelFuture bind(SocketAddress localAddress, ChannelPromise promise) {
                return null;
            }

            @Override
            public ChannelFuture connect(SocketAddress remoteAddress, ChannelPromise promise) {
                return null;
            }

            @Override
            public ChannelFuture connect(SocketAddress remoteAddress, SocketAddress localAddress,
                ChannelPromise promise) {
                return null;
            }

            @Override
            public ChannelFuture disconnect(ChannelPromise promise) {
                return null;
            }

            @Override
            public ChannelFuture close(ChannelPromise promise) {
                return null;
            }

            @Override
            public ChannelFuture deregister(ChannelPromise promise) {
                return null;
            }

            @Override
            public ChannelFuture write(Object msg) {
                return null;
            }

            @Override
            public ChannelFuture write(Object msg, ChannelPromise promise) {
                return null;
            }

            @Override
            public ChannelFuture writeAndFlush(Object msg, ChannelPromise promise) {
                return null;
            }

            @Override
            public ChannelFuture writeAndFlush(Object msg) {
                return null;
            }

            @Override
            public ChannelPromise newPromise() {
                return null;
            }

            @Override
            public ChannelProgressivePromise newProgressivePromise() {
                return null;
            }

            @Override
            public ChannelFuture newSucceededFuture() {
                return null;
            }

            @Override
            public ChannelFuture newFailedFuture(Throwable cause) {
                return null;
            }

            @Override
            public ChannelPromise voidPromise() {
                return null;
            }
        };
        Random rd = new Random();
        byte[] msg;
        for (int i = 0; i < 100; i++) {
            msg = new byte[] {(byte)(rd.nextInt(5) + 20), (byte)(rd.nextInt(5) + 20), (byte)(rd.nextInt(5) + 20),
                (byte)(rd.nextInt(5) + 20), (byte)(rd.nextInt(5) + 20), (byte)(rd.nextInt(5) + 20),
                (byte)(rd.nextInt(5) + 20), (byte)(rd.nextInt(5) + 20), (byte)(rd.nextInt(5) + 20),
                (byte)(rd.nextInt(5) + 20), (byte)(rd.nextInt(5) + 20), (byte)(rd.nextInt(5) + 20),
                (byte)(rd.nextInt(5) + 20), (byte)(rd.nextInt(5) + 20), (byte)(rd.nextInt(5) + 20),
                (byte)(rd.nextInt(5) + 20), (byte)(rd.nextInt(5) + 20), (byte)(rd.nextInt(5) + 20),
                (byte)(rd.nextInt(5) + 20), (byte)(rd.nextInt(5) + 20), (byte)(rd.nextInt(5) + 20),
                (byte)(rd.nextInt(5) + 20), (byte)(rd.nextInt(5) + 20), (byte)(rd.nextInt(5) + 20),
                (byte)(rd.nextInt(5) + 20), (byte)(rd.nextInt(5) + 20), (byte)(rd.nextInt(5) + 20),
                (byte)(rd.nextInt(5) + 20), (byte)(rd.nextInt(5) + 20), (byte)(rd.nextInt(5) + 20),
                (byte)(rd.nextInt(40) + 25), (byte)(rd.nextInt(40) + 25), (byte)(rd.nextInt(40) + 25),
                (byte)(rd.nextInt(40) + 25), (byte)(rd.nextInt(40) + 25), (byte)(rd.nextInt(40) + 25),
                (byte)(rd.nextInt(40) + 25), (byte)(rd.nextInt(40) + 25), (byte)(rd.nextInt(40) + 25),
                (byte)(rd.nextInt(40) + 25)};
            nettyServerHandler.channelRead(channelHandlerContext, msg);
            Thread.sleep(30000);
        }
    }
}