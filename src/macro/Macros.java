package macro;

import java.util.Arrays;

import util.ArrayUtil;

/**
 * Class representing a set of macronutrients (the {@code enum}eration set
 * {@link Macro} except for {@link Macro#NONE}).
 * 
 * @author Zimon
 * @date 2017-06-24
 */
public class Macros {
    /**
     * The macronutrient values.
     */
    private Macro[] macros;

    /**
     * Constructs a {@link Macros} object with no initial values.
     */
    public Macros() {
        this(new int[Macro.number()]);
    }

    /**
     * Constructs a collection of macronutrients with intial values.
     * 
     * @param values
     *            The initial values which amount must be the same at most
     *            {@link Macro#number()}.
     */
    public Macros(int[] values) {
        this.macros = new Macro[Macro.number()];
        set(values);
    }

    /**
     * Sets the macronutrient values.
     * 
     * @param values
     *            The initial values which amount must be the same at most
     *            {@link Macro#number()}.
     */
    public void set(int[] values) {
        for (int i = 0; i < check(values).length; ++i) {
            macros[i].set(values[i]);
        }
    }

    /**
     * Retrieves the macronutrient given its name.
     * 
     * @param name
     *            The name of the macronutrient.
     * @return
     *         the macronutrient object ({@link Macro}) with the name
     *         {@code name}.
     */
    public int get(String name) {
        return get(ArrayUtil.indexOf(macros, Macro.get(name)));
    }

    /**
     * Retrieves the macronutrient at a certain index.
     * 
     * @param index
     *            The index: [0, {@link Macro#number()}].
     * @return
     *         the macronutrient object ({@link Macro}) at index {@code index}.
     */
    public int get(int index) {
        return macros[index].value();
    }

    /**
     * Verifies that an array of integer values is of an applicable length.
     * 
     * @param values
     *            The array to verify.
     * @return
     *         the array, if its length is applicable ([0,
     *         {@link Macro#number()}]).
     * @throws IllegalArgumentException
     *             if the length is not applicable.
     */
    private static int[] check(int[] values) {
        int expected = Macro.number();
        int length = values.length;

        if (expected < length) {
            throw new IllegalArgumentException("Invalid number of macronutrient values; received " + length + " ("
                    + Arrays.toString(values) + "), expected at most " + expected + " values.");
        }

        return values;
    }

    public void add(Macros other) {
        for (int i = 0; i < macros.length; ++i) {
            macros[i].add(other.macros[i]);
        }
    }
}
