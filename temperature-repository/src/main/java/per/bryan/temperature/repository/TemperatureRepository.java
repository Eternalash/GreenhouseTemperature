package per.bryan.temperature.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import per.bryan.temperature.mapper.TemperatureDao;

import javax.annotation.Resource;

/**
 * @Author:bryan.c
 * @Date:2020/10/26
 */
@Component
public class TemperatureRepository {

    @Resource
    private TemperatureDao temperatureMapper;

}
