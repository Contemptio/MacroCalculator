package macro;

import java.util.ArrayList;
import java.util.Collection;

/**
 * A class representing a meal, i.e. a collection of {@link Food}s.
 * 
 * @author Zimon
 * @date 2017-06-24
 */
public class Meal {
    private String name;
    private Collection<? extends Food> foods;

    public Meal(String name) {
        this(name, new ArrayList<Food>());
    }

    public Meal(String name, Collection<? extends Food> foods) {
        this.name = name;
        this.foods = new ArrayList<Food>(foods);
    }

    public Macros macronutrients() {
        Macros macros = new Macros();
        for (Food food : foods) {
            macros.add(food.macros());
        }
        return macros;
    }
}
