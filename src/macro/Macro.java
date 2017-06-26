package macro;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * A class representing macronutrients.
 * 
 * @author Zimon
 * @date 2017-06-24
 */
public enum Macro {
    /**
     * Represents a carbohydrate value.
     */
    CARBOHYDRATE,

    /**
     * Represents a fat value.
     */
    FAT,

    /**
     * Represents a fiber value.
     */
    FIBER,

    /**
     * Represents a protein value.
     */
    PROTEIN,

    /**
     * Represents a non-value.
     */
    NONE;

    /**
     * A map for retrieving {@link Macro} values from their {@link String}
     * representation.
     */
    private static final Map<String, Macro> stringToEnum = Collections.<String, Macro>unmodifiableMap(buildMap());

    /**
     * The number of values represented by this {@code enum}eration.
     * <p>
     * The value {@link #NONE} does not count towards this amount.
     */
    private static final int length = stringToEnum.size() - 1;

    /**
     * The amount of grams of {@code this} macronutrient.
     */
    private int value;

    /**
     * Retrieves the amount of grams of {@code this} macronutrient.
     * 
     * @return
     *         the amount of grams of {@code this} macronutrient.
     */
    public int value() {
        return value;
    }

    /**
     * Sets the amount of grams of {@code this} macronutrient to a new value.
     * 
     * @param value
     *            The new value to set {@code this} to.
     */
    public void set(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("A macronutrient can not have a negative value.");
        }
        this.value = value;
    }

    /**
     * Constructs a macronutrient object.
     */
    private Macro() {
        this(0);
    }

    /**
     * Constructs a macronutrient object.
     * 
     * @param value
     *            the amount of grams of {@code this} macronutrient.
     */
    private Macro(int value) {
        this.value = value;
    }

    /**
     * Retrieves the number of macronutrients represented by this class.
     * 
     * @return
     *         the number of macronutrients represented by this class.
     */
    public static int number() {
        return length;
    }

    /**
     * Retrieves the macronutrient {@code enumeration} value of a {@link Macro}
     * instance given its {@link String} representation.
     * 
     * @param name
     *            the {@link String} representation.
     * @return
     *         the macronutrient {@code enumeration} value of a {@link Macro}
     *         instance.
     */
    public static Macro get(String name) {
        String key = name.toUpperCase();
        if (!stringToEnum.containsKey(key)) {
            return NONE;
        }
        return stringToEnum.get(key);
    }

    /**
     * Builds a map of all of the enumeration values in {@link Macro}.
     * 
     * @return
     *         a map of all enumeration values in {@link Macro} mapped to by
     *         their {@link String} representation.
     */
    private static Map<String, Macro> buildMap() {
        Map<String, Macro> map = new HashMap<String, Macro>();
        for (Macro macro : values()) {
            map.put(macro.name(), macro);
        }
        return map;
    }

    public void add(Macro macro) {
        this.value += macro.value;
    }

}
