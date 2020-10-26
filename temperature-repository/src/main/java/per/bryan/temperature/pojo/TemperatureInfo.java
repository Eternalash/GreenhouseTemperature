package per.bryan.temperature.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;

/**
 * @Author:bryan.c
 * @Date:2020/10/26
 */
@Setter
@Getter
@Table(name="temperatureInfo")
public class TemperatureInfo {
    private String greenhouseNo;
    private String temperature1;
    private String temperature2;
    private String temperature3;
    private String humidity;
}
