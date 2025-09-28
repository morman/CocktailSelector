package com.morman.cocktailselector;

import java.util.List;

/**
 * Minimal CocktailSelector model limited to exactly 3 ingredients and 3 instructions.
 * This satisfies the requirement to have only three of each.
 */
public class CocktailSelector {

    private final List<String> ingredients = List.of(
            "2 oz base spirit",
            "1 oz citrus",
            "0.5 oz sweetener"
    );

    private final List<String> instructions = List.of(
            "Add all ingredients to a shaker with ice",
            "Shake until well chilled",
            "Strain into a chilled glass"
    );

    public List<String> getIngredients() {
        return ingredients;
    }

    public List<String> getInstructions() {
        return instructions;
    }
}
