import client.LocalhostClient;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class EsApiTest {
    private final Logger LOG = LoggerFactory.getLogger(EsApiTest.class);

    @Test
    public void searchTest() {
        try (RestHighLevelClient client = LocalhostClient.create()) {
            SearchRequest request = new SearchRequest();
            request.indices("kibana_sample_data_logs");
            SearchResponse resp = client.search(request, RequestOptions.DEFAULT);
            LOG.info("search response status code: {}", resp.status().getStatus());
        } catch (IOException e) {
            LOG.error("unknown error e");
            throw new RuntimeException(e);
        }
    }
}
