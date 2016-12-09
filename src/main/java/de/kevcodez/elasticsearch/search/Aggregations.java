package de.kevcodez.elasticsearch.search;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.metrics.avg.Avg;
import org.elasticsearch.search.aggregations.metrics.avg.AvgAggregationBuilder;

import de.kevcodez.elasticsearch.Client;
import lombok.extern.log4j.Log4j2;

/**
 * Sample aggregation.
 *
 * @author Kevin
 */
@Log4j2
public class Aggregations {

    public static void main(String[] args) {
        AvgAggregationBuilder avgAggregation = AggregationBuilders
            .avg("averagePrice")
            .field("totalPrice");

        try (TransportClient client = Client.create()) {
            SearchResponse searchResponse = client.prepareSearch()
                .setQuery(QueryBuilders.matchAllQuery())
                .addAggregation(avgAggregation)
                .get();

            Avg average = searchResponse.getAggregations().get("averagePrice");
            log.info("Took {} millis", searchResponse.getTook().millis());
            log.info("Average total price: {}", average.getValue());
        }
    }

}
