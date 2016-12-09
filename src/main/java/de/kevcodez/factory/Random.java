package de.kevcodez.factory;

import java.util.List;

/**
 * Helper class for creating random numbers.
 *
 * @author Kevin
 */
public class Random {

    private static java.util.Random random = new java.util.Random();

    public static int number(int maxNumber) {
        return numberBetween(0, maxNumber);
    }

    public static int numberBetween(int min, int max) {
        return random.ints(min, (max + 1)).findFirst().getAsInt();
    }

    public static String fromStringList(List<String> strings) {
        return strings.get(number(strings.size() - 1));
    }

}
