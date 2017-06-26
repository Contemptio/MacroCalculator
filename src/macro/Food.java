package macro;

import java.util.Arrays;

import util.IntegerUtil;

/**
 * A class representing a food item.
 * 
 * @author Zimon
 * @date 2017-06-24
 */
public class Food {
    /**
     * The name of {@code this} food.
     */
    private String name;

    /**
     * The macronutrients of {@code this} food.
     */
    private Macros macros;

    /**
     * Constructs a food object with macronutrients set to 0.
     * 
     * @param name
     *            The name of the food.
     */
    public Food(String name) {
        this(name, new int[Macro.number()]);
    }

    /**
     * Constructs a food object with macronutrient values.
     * 
     * @param name
     *            The name of the food.
     * @param values
     *            The macronutrient values.
     */
    public Food(String name, int[] values) {
        this.name = name;
        this.macros = new Macros(values);
    }

    public Macros macros() {
        return macros;
    }
}
