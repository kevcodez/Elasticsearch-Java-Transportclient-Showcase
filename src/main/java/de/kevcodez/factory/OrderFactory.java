package de.kevcodez.factory;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import de.kevcodez.model.Customer;
import de.kevcodez.model.Order;
import de.kevcodez.model.OrderItem;
import de.kevcodez.model.Product;

/**
 * Factory for creating random orders.
 *
 * @author Kevin
 */
public class OrderFactory implements Factory<Order> {

    public Order createRandom() {
        List<Customer> customers = MockedDatabase.getInstance().getCustomers();
        List<Product> products = MockedDatabase.getInstance().getProducts();

        Customer customer = customers.get(Random.number(customers.size() - 1));

        List<OrderItem> orderItems = IntStream
            .range(0, Random.numberBetween(1, 3))
            .boxed()
            .map(i -> createRandomOrderItem(products))
            .collect(Collectors.toList());

        BigDecimal totalPrice = orderItems.stream().map(OrderItem::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);

        Order order = Order.builder()
            .orderItems(orderItems)
            .deliveryAddress(customer.getAddresses().get(0))
            .time(generateRandomDateTime())
            .customer(customer)
            .shippingCosts(BigDecimal.valueOf(Random.numberBetween(0, 10)))
            .totalPrice(totalPrice)
            .build();

        return order;
    }

    private static LocalDateTime generateRandomDateTime() {
        int randomHour = Random.numberBetween(0, 23);
        int randomMinute = Random.numberBetween(0, 59);
        int randomSecond = Random.numberBetween(0, 59);

        int randomYear = Random.numberBetween(2014, 2016);
        int randomMonth = Random.numberBetween(1, 12);
        int randomDay = Random.numberBetween(1, 18);

        return LocalDateTime.of(randomYear, randomMonth, randomDay, randomHour, randomMinute, randomSecond);
    }

    private static OrderItem createRandomOrderItem(List<Product> products) {
        Product product = products.get(Random.number(products.size() - 1));

        return OrderItem.builder()
            .product(product)
            .price(product.getPrice()).build();
    }

}
