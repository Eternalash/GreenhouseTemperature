package per.bryan.temperature.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.collect.Lists;

import per.bryan.temperature.mapper.TemperatureDao;
import per.bryan.temperature.mapper.TemperatureExample;
import per.bryan.temperature.pojo.Temperature;
import per.bryan.temperature.pojo.TemperatureInfo;

/**
 * @Author:bryan.c
 * @Date:2020/10/26
 */
@Controller
@SuppressWarnings("all")
public class TemperatureController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TemperatureController.class);

    @Autowired
    private TemperatureDao temperatureMapper;

    @RequestMapping(value = "/temperatures")
    public String temperatures(Model model) {
        TemperatureExample example = new TemperatureExample();
        example.setOrderByClause("date");
        example.setOrderByClause("greenhouseNo");
        List<String> greenHouses = Lists.newArrayList("01", "02", "03");
        TemperatureExample.Criteria criteria = example.createCriteria();
        criteria.andGreenhouseNoIn(greenHouses);
        example.setLimit(greenHouses.size() * 3);
        List<TemperatureInfo> temperatureInfos=new ArrayList<>();
        try {
            temperatureInfos= temperatureMapper.selectByExample(example).stream()
                    .sorted(Comparator.comparing(Temperature::getSensorNo))
                    .collect(Collectors.groupingBy(Temperature::getGreenhouseNo)).entrySet().stream().map(stringListEntry -> {
                        TemperatureInfo temperatureInfo = new TemperatureInfo();
                        temperatureInfo.setGreenhouseNo(stringListEntry.getKey());
                        temperatureInfo.setTemperature1(stringListEntry.getValue().get(0).getTemperature());
                        temperatureInfo.setTemperature2(stringListEntry.getValue().get(1).getTemperature());
                        temperatureInfo.setTemperature3(stringListEntry.getValue().get(2).getTemperature());
                        temperatureInfo.setHumidity(stringListEntry.getValue().get(2).getHumidity());
                        return temperatureInfo;
                    }).collect(Collectors.toList());
        }
        catch (Exception e){
            LOGGER.error("db failed",e);
        }
        model.addAttribute("temperatureInfos", temperatureInfos);
        return "temperature";
    }

    @RequestMapping(value = "/temperatures/refresh")
    public String refresh(Model model) {
        TemperatureExample example = new TemperatureExample();
        example.setOrderByClause("date");
        example.setOrderByClause("greenhouseNo");
        List<String> greenHouses = Lists.newArrayList("01", "02", "03");
        TemperatureExample.Criteria criteria = example.createCriteria();
        criteria.andGreenhouseNoIn(greenHouses);
        example.setLimit(greenHouses.size() * 3);
        List<TemperatureInfo> temperatureInfos=new ArrayList<>();
        try {
            temperatureInfos = temperatureMapper.selectByExample(example).stream()
                    .sorted(Comparator.comparing(Temperature::getSensorNo))
                    .collect(Collectors.groupingBy(Temperature::getGreenhouseNo)).entrySet().stream().map(stringListEntry -> {
                        TemperatureInfo temperatureInfo = new TemperatureInfo();
                        temperatureInfo.setGreenhouseNo(stringListEntry.getKey());
                        temperatureInfo.setTemperature1(stringListEntry.getValue().get(0).getTemperature());
                        temperatureInfo.setTemperature2(stringListEntry.getValue().get(1).getTemperature());
                        temperatureInfo.setTemperature3(stringListEntry.getValue().get(2).getTemperature());
                        temperatureInfo.setHumidity(stringListEntry.getValue().get(2).getHumidity());
                        return temperatureInfo;
                    }).collect(Collectors.toList());
        }catch (Exception e){
            LOGGER.error("db failed",e);
        }
        model.addAttribute("temperatureInfos", temperatureInfos);
        return "temperature::table_refresh";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "/error/access-denied";
    }
}
