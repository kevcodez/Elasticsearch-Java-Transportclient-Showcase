package de.kevcodez.factory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import de.kevcodez.model.AbstractEntity;
import de.kevcodez.model.Customer;
import de.kevcodez.model.Order;
import de.kevcodez.model.Product;

/**
 * Generates random orders and puts them into elastic search.
 *
 * @author Kevin
 */
public class DataGenerator {

    private OrderFactory orderFactory = new OrderFactory();
    private ProductFactory productFactory = new ProductFactory();
    private CustomerFactory customerFactory = new CustomerFactory();

    public String get() {
        return "";
    }


    public void createRandomOrders(int amount) {
        List<Order> randomOrders = createRandoms(Order.class, orderFactory, amount);
        randomOrders.forEach(MockedDatabase.getInstance()::addOrder);
    }

    public void createRandomProducts(int amount) {
        List<Product> randomProducts = createRandoms(Product.class, productFactory, amount);
        randomProducts.forEach(MockedDatabase.getInstance()::addProduct);
    }

    public void createRandomCustomers(int amount) {
        List<Customer> randomOrders = createRandoms(Customer.class, customerFactory, amount);
        randomOrders.forEach(MockedDatabase.getInstance()::addCustomer);
    }

    private <T> List<T> createRandoms(Class<T> clazz, Factory factory, int amount) {
        List<AbstractEntity> entities = IntStream.rangeClosed(1, amount)
            .boxed()
            .map(pos -> factory.createRandom())
            .collect(Collectors.toList());

        IntStream.range(1, amount).forEach(pos -> entities.get(pos).setId(Long.valueOf(pos)));

        return (List<T>) entities;
    }

}
