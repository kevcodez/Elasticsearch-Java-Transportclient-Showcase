package de.kevcodez.elasticsearch.search;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;

import de.kevcodez.elasticsearch.Client;
import lombok.extern.log4j.Log4j2;

/**
 * Sample searching.
 *
 * @author Kevin
 */
@Log4j2
public class BasicSearch {

    public static void main(String[] args) {
        try (TransportClient client = Client.create()) {
            SearchResponse response = client.prepareSearch().get();
            logSearchResponse(response);

            SearchResponse detailedResponse = client.prepareSearch("orders")
                .setTypes("order")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setPostFilter(QueryBuilders.rangeQuery("totalPrice").from(1).to(20))
                .setFrom(0)
                .setSize(60)
                .get();

            logSearchResponse(detailedResponse);
        }
    }

    private static void logSearchResponse(SearchResponse response) {
        SearchHits hits = response.getHits();
        log.info("Result size: " + hits.totalHits());
        log.info(response);
    }


}
