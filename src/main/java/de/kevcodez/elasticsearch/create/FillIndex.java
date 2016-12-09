package de.kevcodez.elasticsearch.create;

import java.util.List;

import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.client.transport.TransportClient;

import com.google.gson.Gson;

import de.kevcodez.elasticsearch.Client;
import de.kevcodez.factory.DataGenerator;
import de.kevcodez.factory.MockedDatabase;
import de.kevcodez.model.Order;
import lombok.extern.log4j.Log4j2;

/**
 * // TODO add class comment
 *
 * @author Kevin
 */
@Log4j2
public class FillIndex {

    private static Gson gson = new Gson();

    private static final int NUM_CUSTOMERS = 2000;
    private static final int NUM_PRODUCTS = 50;
    private static final int NUM_ORDERS = 10000;

    private static DataGenerator dataGenerator = new DataGenerator();

    public static void main(String[] args) {
        dataGenerator.createRandomCustomers(NUM_CUSTOMERS);
        dataGenerator.createRandomProducts(NUM_PRODUCTS);
        dataGenerator.createRandomOrders(NUM_ORDERS);

        List<Order> randomOrders = MockedDatabase.getInstance().getOrders();

        try (TransportClient client = Client.create()) {
            BulkRequestBuilder bulkRequest = client.prepareBulk();

            randomOrders.stream().map(gson::toJson).forEach(jsonOrder -> {
                log.debug(jsonOrder);

                IndexRequestBuilder indexRequest = client
                    .prepareIndex("orders", "order")
                    .setSource(jsonOrder);

                bulkRequest.add(indexRequest);
            });

            BulkResponse bulkResponse = bulkRequest.get();
            if (bulkResponse.hasFailures()) {
                throw new RuntimeException("Bulk response has exceptions");
            }
        }
    }
}
