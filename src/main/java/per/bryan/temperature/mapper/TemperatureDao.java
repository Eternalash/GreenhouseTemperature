package per.bryan.temperature.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Component;
import per.bryan.temperature.pojo.Temperature;

@Mapper
@Component
public interface TemperatureDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Temperature record);

    int insertSelective(Temperature record);

    Temperature selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Temperature record);

    int updateByPrimaryKey(Temperature record);

    Temperature selectOneByGreenhouseNoAndSensorNoOrderByIdDesc(@Param("greenhouseNo") String greenhouseNo,
        @Param("sensorNo") String sensorNo);

}