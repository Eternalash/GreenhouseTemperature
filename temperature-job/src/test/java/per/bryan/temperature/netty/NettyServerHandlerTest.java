package per.bryan.temperature.netty;

import java.net.SocketAddress;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.google.gson.Gson;
import org.assertj.core.util.DateUtil;
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
import per.bryan.temperature.common.DateJsonDeserializer;
import per.bryan.temperature.common.DateJsonSerializer;
import per.bryan.temperature.common.JsonUtils;
import per.bryan.temperature.entity.TemperatureEntity;
import per.bryan.temperature.pojo.Temperature;

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
        ChannelHandlerContext channelHandlerContext=new ChannelHandlerContext() {
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
            public ChannelFuture connect(SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) {
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
        byte[] msg=new byte[] {(byte)25,(byte)26,(byte)25,(byte)50,
                (byte)26,(byte)25,(byte)26,(byte)51,
                (byte)25,(byte)26,(byte)25,(byte)52,
                (byte)26,(byte)25,(byte)26,(byte)53,
                (byte)25,(byte)26,(byte)25,(byte)54,
                (byte)26,(byte)25,(byte)26,(byte)55,
                (byte)25,(byte)26,(byte)25,(byte)56,
                (byte)26,(byte)25,(byte)26,(byte)57,
                (byte)25,(byte)26,(byte)25,(byte)58,
                (byte)26,(byte)25,(byte)26,(byte)59};
        nettyServerHandler.channelRead(channelHandlerContext,msg);
    }
}