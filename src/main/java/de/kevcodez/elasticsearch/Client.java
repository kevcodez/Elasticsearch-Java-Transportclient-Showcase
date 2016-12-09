package de.kevcodez.elasticsearch;

import java.net.InetAddress;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import lombok.SneakyThrows;

/**
 * Creates an Elasticsearch client.
 *
 * @author Kevin
 */
public class Client {

    public static final String HOST = "localhost";
    public static final int PORT = 9300;

    @SneakyThrows
    public static TransportClient create() {
        return new PreBuiltTransportClient(Settings.EMPTY)
            .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(HOST), PORT));
    }

}
