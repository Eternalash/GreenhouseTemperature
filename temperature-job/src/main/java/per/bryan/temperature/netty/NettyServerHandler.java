package per.bryan.temperature.netty;

import static per.bryan.temperature.common.ByteUtil.getUnsignedByte;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
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
    ObjectMapper mapper = new ObjectMapper();

    /**
     * 读取客户端发送来的数据
     * 
     * @param ctx ChannelHandler的上下文对象 有管道 pipeline 通道 channel 和 请求地址 等信息
     * @param msg 客户端发送的具体数据
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        byte[] bytes = (byte[])msg;
        try {
            int insert = insertTemperatures(bytes);
            log.info("NettyServerHandler insertTemperatures insert = {}, channel buf = {}", insert,
                mapper.writeValueAsString(bytes));
        } catch (Exception e) {
            log.error("NettyServerHandler insertTemperatures exception, channel buf = {}",
                mapper.writeValueAsString(bytes));
        } finally {
            ctx.close();
        }
    }

    @Transactional(transactionManager = "temperatureTransactionManager", rollbackFor = Exception.class)
    private int insertTemperatures(byte[] bytes) throws Exception {
        if (ObjectUtils.isEmpty(bytes))
            return -1;
        int result = 0;
        LocalDateTime localDateTime = LocalDateTime.now();
        for (int i = 0; i < 30; i++) {
            int value = getUnsignedByte(bytes[i]);
            Temperature temperature = new Temperature();
            switch (i % 3) {
                case 0:
                    temperature.setSensorNo("1");
                    break;
                case 1:
                    temperature.setSensorNo("2");
                    break;
                case 2:
                    temperature.setSensorNo("3");
                    break;
            }
            temperature.setGreenhouseNo(String.valueOf(i / 3));
            temperature.setTemperature(String.valueOf(value));
            temperature.setHumidity(String.valueOf(getUnsignedByte(bytes[i / 3 + 30])));
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
        // writeAndFlush 是组合方法
        ctx.writeAndFlush(Unpooled.copiedBuffer("你好啊，客户端....^_^", StandardCharsets.UTF_8));
    }
}
