# Elasticsearch Java API

This repository contains code showing how to use the Elasticsearch API for Java.

## Setup

Download Elasticsearch from the official website
https://www.elastic.co/de/downloads/elasticsearch

Unzip the folder and navigate into bin.

Execute the elasticsearch.bat / elasticsearch.sh.

Run the de.kevcodez.elasticsearch.create.FillIndex class that generates a few thousand of orders and puts them into Elasticsearch.

You may now run de.kevcodez.elasticsearch.search.Aggregations or de.kevcodez.elasticsearch.search.BasicSearch.

### Edit Host/Port

The de.kevcodez.elasticsearch.Client creates an Elasticsearch client with the default Port 9300 and host localhost.

### Lombok

This project uses Lombok, see http://projectlombok.org for reference.

## Further reading

Java API Overview: https://www.elastic.co/guide/en/elasticsearch/client/java-api/current/index.html