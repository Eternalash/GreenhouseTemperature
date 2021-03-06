package per.bryan.temperature.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import per.bryan.temperature.pojo.Temperature;

@Mapper
public interface TemperatureDao {
    long countByExample(TemperatureExample example);

    int deleteByExample(TemperatureExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Temperature record);

    int insertSelective(Temperature record);

    List<Temperature> selectByExample(TemperatureExample example);

    Temperature selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Temperature record, @Param("example") TemperatureExample example);

    int updateByExample(@Param("record") Temperature record, @Param("example") TemperatureExample example);

    int updateByPrimaryKeySelective(Temperature record);

    int updateByPrimaryKey(Temperature record);
}