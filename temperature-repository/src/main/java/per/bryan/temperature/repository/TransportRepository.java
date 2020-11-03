package per.bryan.temperature.repository;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.elasticsearch.client.NodeSelector;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.springframework.stereotype.Component;

/**
 * @Author:bryan.c
 * @Date:2020/11/3
 */
@Component
public class TransportRepository {
    public boolean postElasticsearch(String json) throws IOException {
        // on startup
        RestClientBuilder builder = RestClient.builder(
                new HttpHost("localhost", 9200, "http"), new HttpHost("localhost", 9201, "http"));
        builder.setNodeSelector(NodeSelector.SKIP_DEDICATED_MASTERS);
        RestClient restClient =builder.build();
        Request request=new Request("POST","/");
        request.setJsonEntity(json);
        restClient.close();
        return true;
    }
}
