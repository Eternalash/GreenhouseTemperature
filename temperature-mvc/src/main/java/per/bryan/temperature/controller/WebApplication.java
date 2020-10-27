package per.bryan.temperature.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @Author:bryan.c
 * @Date:2020/10/26
 */
@SpringBootApplication //scanBasePackages = {"per.bryan.temperature.repository"}
@MapperScan("per.bryan.temperature.mapper")
//@ImportResource({
//        "classpath:/mybatis/mapper/TemperatureDao.xml"
//})
public class WebApplication  extends SpringBootServletInitializer {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(WebApplication.class, args);
    }

}