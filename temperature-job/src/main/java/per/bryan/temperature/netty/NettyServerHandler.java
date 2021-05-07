package per.bryan.temperature.netty;

import static per.bryan.temperature.common.ByteUtil.getUnsignedByte;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.primitives.Bytes;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import lombok.extern.slf4j.Slf4j;
import per.bryan.temperature.mapper.TemperatureDao;
import per.bryan.temperature.pojo.Temperature;
import per.bryan.temperature.repository.TransportRepository;

/**
 * @Author:bryan.c
 * @Date:2020/10/19
 */
@Component
@ChannelHandler.Sharable
@Slf4j
@SuppressWarnings("all")
public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    @Autowired
    private TemperatureDao temperatureMapper;
    @Autowired
    private TransportRepository transportRepository;
    @Value("${support.remote.address}")
    private String address;
    ObjectMapper mapper = new ObjectMapper();

    /**
     * 读取客户端发送来的数据
     * 
     * @param ctx ChannelHandler的上下文对象 有管道 pipeline 通道 channel 和 请求地址 等信息
     * @param msg 客户端发送的具体数据
     * @throws Exception
     */
    @Override
    @Transactional(transactionManager = "temperatureTransactionManager", rollbackFor = IOException.class)
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws IOException {
        InetSocketAddress ipSocket = (InetSocketAddress)ctx.channel().remoteAddress();
        String clientIp = ipSocket.getAddress().getHostAddress();
        log.info("source msg type -->"+msg.getClass().getName()+"-->\n"+msg+"-->IP:"+clientIp);
        ByteBuf bufReq = Unpooled.buffer();
        byte[] bytes = String.valueOf(msg).getBytes();
        try {
//            if(!clientIp.equalsIgnoreCase(address)){
//                throw new Exception("unsupport remote address");
//            }
            int insert = insertTemperatures(bytes);
            log.info("NettyServerHandler insertTemperatures insert = {}, channel buf = ->{}<-", insert,
                printMsg(bytes));
        } catch (IOException e) {
            log.error("NettyServerHandler insertTemperatures exception, channel buf = ->{}<-", printMsg(bytes));
            bufReq.writeBytes("failed\n".getBytes());
            HttpResponse httpResponse=new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.EXPECTATION_FAILED,bufReq);
            ctx.writeAndFlush(httpResponse);
            throw e;
        } finally {
            bufReq.release();
            ctx.close();
        }
    }

    private String printMsg(byte[] bytes) {
        return Bytes.asList(bytes).stream().map(by -> String.valueOf(by)).reduce((s1, s2) -> s1 + "," + s2).orElse("");
    }

    private int insertTemperatures(byte[] bytes) throws IOException {
        if (ObjectUtils.isEmpty(bytes))
            return -1;
        int result = 0;
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("+08:00"));
        for (int i = 0; i < 30; i++) {
            int value = getUnsignedByte(bytes[i]);
            Temperature temperature = new Temperature();
            switch (i % 3) {
                case 0:
                    temperature.setSensorNo("1");
                    temperature.setHumidity("0");
                    break;
                case 1:
                    temperature.setSensorNo("2");
                    temperature.setHumidity("0");
                    break;
                case 2:
                    temperature.setSensorNo("3");
                    temperature.setHumidity(String.valueOf(getUnsignedByte(bytes[i / 3 + 30])));
                    break;
            }
            temperature.setGreenhouseNo(String.valueOf(i / 3));
            temperature.setTemperature(String.valueOf(value));
            temperature.setDate(localDateTime);
            temperatureMapper.insert(temperature);
            transportRepository.postElasticsearch(temperature);
            result++;
        }
        return result;
    }

    /**
     * 读取客户端发送数据完成后的方法 在本方法中可以发送返回的数据
     * 
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes("success".getBytes());
        HttpResponse httpResponse=new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK,buf);
        ctx.writeAndFlush(httpResponse);
    }
}
