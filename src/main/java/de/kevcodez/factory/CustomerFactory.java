package de.kevcodez.factory;

import static de.kevcodez.factory.Random.fromStringList;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import de.kevcodez.model.Address;
import de.kevcodez.model.Customer;

/**
 * Factory for creating random customers.
 *
 * @author Kevin
 */
public class CustomerFactory implements Factory<Customer> {

    private static final List<String> firstNames = Arrays.asList("Kevin", "Hans", "Franz", "Marko", "Juli", "Sarafina");
    private static final List<String> lastNames = Arrays.asList("Meier", "Müller", "Strauß", "Schulz", "Steinbrunner");

    private AddressFactory addressFactory = new AddressFactory();

    public Customer createRandom() {
        Address randomAddress = addressFactory.createRandom();

        Customer customer = Customer.builder()
            .firstName(fromStringList(firstNames))
            .lastName(fromStringList(lastNames))
            .birthdate(generateRandomBirthdate())
            .build();

        randomAddress.setName(String.format("%s %s", customer.getFirstName(), customer.getLastName()));
        customer.setAddresses(Arrays.asList(randomAddress));

        return customer;
    }

    private static LocalDate generateRandomBirthdate() {
        int randomYear = Random.numberBetween(1940, 2016);
        int randomDay = Random.numberBetween(1, 28);
        int randomMonth = Random.numberBetween(1, 12);
        return LocalDate.of(randomYear, randomMonth, randomDay);
    }

}
