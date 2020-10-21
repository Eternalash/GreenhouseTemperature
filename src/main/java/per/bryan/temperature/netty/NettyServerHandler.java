package per.bryan.temperature.netty;

import com.google.gson.Gson;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import per.bryan.temperature.mapper.TemperatureDao;
import per.bryan.temperature.pojo.Temperature;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

/**
 * @Author:bryan.c
 * @Date:2020/10/19
 */
@Component
@ChannelHandler.Sharable
@SuppressWarnings("all")
public class NettyServerHandler  extends ChannelInboundHandlerAdapter {
    @Autowired
    private TemperatureDao temperatureMapper;

    /**
     * 读取客户端发送来的数据
     * @param ctx ChannelHandler的上下文对象 有管道 pipeline 通道 channel 和 请求地址 等信息
     * @param msg 客户端发送的具体数据
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("客户端请求到了..." + ctx.channel().remoteAddress());
        ByteBuf buf = (ByteBuf) msg;
        Temperature temperature=new Temperature();
        temperature.setGreenhouseNo("01");
        temperature.setSensorNo("#1");
        temperature.setTemperature("25");
        temperature.setHumidity("50");
        temperature.setDate(LocalDateTime.now());
        int id= temperatureMapper.insert(temperature);
        System.out.println(new Gson().toJson(temperatureMapper.selectByPrimaryKey(id)));
        System.out.println("客户端发送的数据是:" +buf.toString(StandardCharsets.UTF_8));
        ctx.close();
    }

    /**
     * 读取客户端发送数据完成后的方法
     *    在本方法中可以发送返回的数据
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        // writeAndFlush 是组合方法
        ctx.writeAndFlush(Unpooled.copiedBuffer("你好啊，客户端....^_^",StandardCharsets.UTF_8));
    }
}
