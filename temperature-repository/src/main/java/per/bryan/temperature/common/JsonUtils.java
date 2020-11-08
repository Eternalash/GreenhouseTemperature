package per.bryan.temperature.common;

import java.time.LocalDateTime;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class JsonUtils {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OBJECT_MAPPER.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

        SimpleModule module = new SimpleModule("DateTimeModule", Version.unknownVersion());
        module.addSerializer(LocalDateTime.class, new DateJsonSerializer());
        module.addDeserializer(LocalDateTime.class, new DateJsonDeserializer());

        OBJECT_MAPPER.registerModule(module);
    }

    public static ObjectMapper mapperInstance() {
        return OBJECT_MAPPER;
    }

    public static String toJson(Object o) {
        if (o == null) {
            return null;
        }
        try {
            return OBJECT_MAPPER.writeValueAsString(o);
        } catch (Exception e) {
            logger.error("to json error.", e);
        }
        return null;
    }

    public static <T> T parseJson(String json, Class<T> clazz) {
        if (json == null || json.length() == 0) {
            return (T) null;
        }
        try {
            return OBJECT_MAPPER.readValue(json, clazz);
        } catch (Exception e) {
            logger.error("parse json error.", e);
            throw new RuntimeException(e);
        }
    }

    public static <T> T parseJson(String json, TypeReference<T> typeReference) {
        if (json == null || json.length() == 0) {
            return (T) null;
        }
        try {
            return OBJECT_MAPPER.readValue(json, typeReference);
        } catch (Exception e) {
            logger.error("parse json error.", e);
            throw new RuntimeException(e);
        }
    }

    public static JsonNode parseJsonNode(String json) {
        if (json == null || json.length() == 0) {
            return null;
        }
        try {
            return OBJECT_MAPPER.readTree(json);
        } catch (Exception e) {
            logger.error("parse json node error.", e);
            throw new RuntimeException(e);
        }
    }
}
