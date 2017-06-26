package util;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for management of integers.
 * 
 * @author Zimon
 * @date 2017-06-24
 */
public class IntegerUtil {

    /**
     * Creates an array ranging from one value to another, incremented by 1.
     * 
     * @param minimum
     *            The minimum value, i.e. the value at index 0.
     * @param maximum
     *            The maximum value, i.e. the value at index
     *            {@code range.size() - 1}.
     * @return
     *         a list containing {@code int}egers from {@code minimum} to
     *         {@code maximum}, incremented by 1 each step.
     */
    public static List<Integer> range(int minimum, int maximum) {
        return range(minimum, maximum, 1);
    }

    /**
     * Creates an array ranging from one value to another, incremented by a
     * certain amount each step.
     * 
     * @param minimum
     *            The minimum value, i.e. the value at index 0.
     * @param maximum
     *            The maximum value, i.e. the value at index
     *            {@code range.size() - 1}.
     * @param step
     *            The difference between two values in the range between
     *            {@code minimum} and {@code maximum}.
     * @return
     *         a list containing {@code int}egers from {@code minimum} to
     *         {@code maximum}, incremented by {@code step} each step.
     */
    @SuppressWarnings("boxing")
    public static List<Integer> range(int minimum, int maximum, int step) {
        int length = maximum - minimum;
        if (length < 0) {
            throw new IllegalArgumentException("Invalid range: [" + minimum + ", " + maximum + "] has negative size.");
        }

        List<Integer> range = new ArrayList<Integer>();
        for (int i = minimum; i < maximum; i += step) {
            range.add(i - minimum);
        }
        range.add(maximum);
        return range;
    }
}
