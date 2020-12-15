package per.bryan.temperature.repository;

import java.io.IOException;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.settings.Settings;
import org.springframework.stereotype.Component;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import per.bryan.temperature.pojo.Temperature;

/**
 * @Author:bryan.c
 * @Date:2020/11/3
 */
@Slf4j
@Component
public class TransportRepository {
    private static  RestHighLevelClient restClient;
    private static final String INDEX="temperatures";
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

    @PostConstruct
    public void init() throws IOException {
        GetIndexRequest getIndexRequest = new GetIndexRequest(INDEX);
        if(!restClient.indices().exists(getIndexRequest, RequestOptions.DEFAULT)) {
            createIndex();
        }
    }

    public void createIndex() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest(INDEX);
        buildSetting(request);
        buildIndexMapping(request);
        restClient.indices().create(request, RequestOptions.DEFAULT);
    }
    //设置分片
    public void buildSetting(CreateIndexRequest request){
        request.settings(Settings.builder().put("index.number_of_shards",3)
                .put("index.number_of_replicas",2));
    }
    //设置index的mapping
    public void buildIndexMapping(CreateIndexRequest request){
        Map<String, Object> jsonMap = new HashMap<>();
        Map<String, Object> typeText = new HashMap<>();
        typeText.put("type", "float");
        Map<String, Object> date = new HashMap<>();
        date.put("type", "date");
        Map<String, Object> keyword = new HashMap<>();
        keyword.put("type", "keyword");
        Map<String, Object> properties = new HashMap<>();
        properties.put("greenhouseNo", keyword);
        properties.put("sensorNo", keyword);
        properties.put("temperature", typeText);
        properties.put("humidity", typeText);
        properties.put("date", date);
        jsonMap.put("properties", properties);
        request.mapping(jsonMap);
    }

    public boolean postElasticsearch(Temperature temperature) throws IOException {
        Map<String,Object> map = new HashMap<>();
        map.put("id",temperature.getId());
        map.put("greenhouseNo",temperature.getGreenhouseNo());
        map.put("sensorNo",temperature.getSensorNo());
        map.put("temperature",temperature.getTemperature());
        map.put("humidity",temperature.getHumidity());
        map.put("date",Date.from(temperature.getDate().atZone( ZoneId.systemDefault()).toInstant()));
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
