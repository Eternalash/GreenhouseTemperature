package per.bryan.temperature;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author:bryan.c
 * @Date:2020/10/19
 */
@SpringBootApplication
@MapperScan("per.bryan.temperature.mapper")
@PropertySource(value={"mybatis/mapper/"})
public class NettyApplication{
    public static void main(String[] args) {
        SpringApplication.run(NettyApplication.class, args);
    }
}