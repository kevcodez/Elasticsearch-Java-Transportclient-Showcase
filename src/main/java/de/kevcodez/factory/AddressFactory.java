package de.kevcodez.factory;

import java.util.Arrays;
import java.util.List;

import de.kevcodez.model.Address;

/**
 * Factory for creating random addresses.
 *
 * @author Kevin
 */
public class AddressFactory implements Factory<Address> {

    private static final List<String> streets = Arrays.asList("Abflugring", "Adalbertstr", "Mainberg", "Zweidlerweg");
    private static final List<String> zipCodes = Arrays.asList("21220", "20535", "21274", "56989", "51230", "78412");

    public Address createRandom() {
        return Address.builder()
            .street(streets.get(Random.number(streets.size() - 1)) + " " + Random.numberBetween(1, 100))
            .zipCode(zipCodes.get(Random.number(zipCodes.size() - 1)))
            .build();
    }

}
