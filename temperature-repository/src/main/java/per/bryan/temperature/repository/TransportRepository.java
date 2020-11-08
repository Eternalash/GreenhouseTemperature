package per.bryan.temperature.repository;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.PreDestroy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.*;
import org.springframework.stereotype.Component;

import lombok.SneakyThrows;
import per.bryan.temperature.common.JsonUtils;
import per.bryan.temperature.pojo.Temperature;

/**
 * @Author:bryan.c
 * @Date:2020/11/3
 */
@Slf4j
@Component
public class TransportRepository {
    private static  RestHighLevelClient restClient;
    static {
        try {
            // on startup
            restClient = new RestHighLevelClient(
                    RestClient.builder(
                            new HttpHost("localhost", 9200, "http")));
        }catch ( Exception e){
            log.error("init failed",e);
            throw e;
        }
    }

    public boolean postElasticsearch(Temperature temperature) throws IOException {
        Map<String,Object> map = JsonUtils.parseJson(JsonUtils.toJson(temperature),new TypeReference<HashMap<String, Object>>() {});
        IndexRequest indexRequest = new IndexRequest("temperatures")
                .id(String.valueOf(temperature.getId())).source(map);
        IndexResponse indexResponse = restClient.index(indexRequest, RequestOptions.DEFAULT);
        return indexResponse.getShardInfo().getSuccessful()==1;
    }

    @SneakyThrows
    @PreDestroy
    public void destory() {
        restClient.close();
    }
}
