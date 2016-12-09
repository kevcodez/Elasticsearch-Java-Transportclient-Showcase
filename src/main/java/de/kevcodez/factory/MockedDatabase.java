package de.kevcodez.factory;

import java.util.List;

import de.kevcodez.model.Customer;
import de.kevcodez.model.Order;
import de.kevcodez.model.Product;
import lombok.Getter;

/**
 * // TODO add class comment
 *
 * @author Kevin
 */
public class MockedDatabase {

    private static MockedDatabase instance;

    private MockedDatabase() {
    }

    public static MockedDatabase getInstance() {
        if (MockedDatabase.instance == null) {
            MockedDatabase.instance = new MockedDatabase();
        }
        return MockedDatabase.instance;
    }

    @Getter
    private List<Product> products;

    @Getter
    private List<Customer> customers;

    @Getter
    private List<Order> orders;

    public void addProduct(Product product) {
        products.add(product);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
}
