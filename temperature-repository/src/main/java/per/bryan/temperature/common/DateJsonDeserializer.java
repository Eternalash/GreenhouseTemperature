package per.bryan.temperature.common;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * @author: bryan.c
 * @date: 2020/11/8 19:47
 * @package: per.bryan.temperature.common
 */
public class DateJsonDeserializer extends JsonDeserializer<LocalDateTime> {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public LocalDateTime deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {

        String date = jp.getText();
        if (Objects.isNull(date)) {
            return LocalDateTime.parse(date, DATE_TIME_FORMATTER);
        }
        return null;
    }
}
