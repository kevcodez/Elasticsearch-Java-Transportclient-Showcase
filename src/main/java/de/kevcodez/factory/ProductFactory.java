package de.kevcodez.factory;

import static de.kevcodez.factory.Random.fromStringList;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import de.kevcodez.model.Product;

/**
 * Factory for creating random products.
 *
 * @author Kevin
 */
public class ProductFactory implements  Factory<Product> {

    private static final List<String> names = Arrays.asList("T-Shirt", "Socks", "Pullover", "Hoodie", "Trousers");

    public Product createRandom() {
        return Product.builder()
            .name(fromStringList(names))
            .price(BigDecimal.valueOf(Random.numberBetween(1, 100)))
            .build();
    }

}
