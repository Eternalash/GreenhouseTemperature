package per.bryan.temperature.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import per.bryan.temperature.mapper.TemperatureDao;
import per.bryan.temperature.pojo.Temperature;
import per.bryan.temperature.pojo.TemperatureInfo;

/**
 * @Author:bryan.c
 * @Date:2020/10/26
 */
@Controller
@RequestMapping("/temperature")
public class TemperatureController {
    @Autowired
    private TemperatureDao temperatureMapper;

    @RequestMapping(value = "/temperatures")
    public String temperatures(Model model) {
        List<TemperatureInfo> temperatureInfos=temperatureMapper.selectOneByDate("2020-10-26 17:33:55").stream()
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
        model.addAttribute("temperatureInfos",temperatureInfos);
        return "temperature";
    }
}
