//package per.bryan.temperature.netty;
//
//import org.apache.ibatis.annotations.Insert;
//import org.apache.ibatis.annotations.Options;
//import org.apache.ibatis.annotations.Select;
//
//import java.util.List;
//
///**
// * @Author:bryan.c
// * @Date:2020/10/20
// */
//public interface TemperatureMapper {
//    @Insert("Insert into temperature(greenhouseNo,sensorNo,temperature,humidity) values (#{greenhouseNo},#{sensorNo},#{temperature},#{humidity})")
//    @Options(useGeneratedKeys = true, keyColumn = "id")
//    int insert(TemperatureDomain record);
//
//    @Select("select * from temperature")
//    List<TemperatureDomain> selectTemperatures();
//
//
//    @Select("select * from temperature where id=#{id}")
//    TemperatureDomain selectTemperature(int id);
//
//    @Select("select * from temperature where greenhouseNo=#{greenhouseNo}")
//    TemperatureDomain selectUserName(String greenhouseNo);
//}
