package com.morman.cocktailselector;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

/**
 * JPA Entity representing a Cocktail with exactly 3 ingredients and 3 instructions.
 * This preserves the constraint from the previous requirement while enabling CRUD operations.
 */
@Entity
public class CocktailSelector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String ingredient1;
    @NotBlank
    private String ingredient2;
    @NotBlank
    private String ingredient3;

    @NotBlank
    private String instruction1;
    @NotBlank
    private String instruction2;
    @NotBlank
    private String instruction3;

    public CocktailSelector() {
        // default values to align with the original minimal example
        this.ingredient1 = "2 oz base spirit";
        this.ingredient2 = "1 oz citrus";
        this.ingredient3 = "0.5 oz sweetener";
        this.instruction1 = "Add all ingredients to a shaker with ice";
        this.instruction2 = "Shake until well chilled";
        this.instruction3 = "Strain into a chilled glass";
    }

    public CocktailSelector(String ingredient1, String ingredient2, String ingredient3,
                            String instruction1, String instruction2, String instruction3) {
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
        this.ingredient3 = ingredient3;
        this.instruction1 = instruction1;
        this.instruction2 = instruction2;
        this.instruction3 = instruction3;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIngredient1() { return ingredient1; }
    public void setIngredient1(String ingredient1) { this.ingredient1 = ingredient1; }
    public String getIngredient2() { return ingredient2; }
    public void setIngredient2(String ingredient2) { this.ingredient2 = ingredient2; }
    public String getIngredient3() { return ingredient3; }
    public void setIngredient3(String ingredient3) { this.ingredient3 = ingredient3; }

    public String getInstruction1() { return instruction1; }
    public void setInstruction1(String instruction1) { this.instruction1 = instruction1; }
    public String getInstruction2() { return instruction2; }
    public void setInstruction2(String instruction2) { this.instruction2 = instruction2; }
    public String getInstruction3() { return instruction3; }
    public void setInstruction3(String instruction3) { this.instruction3 = instruction3; }
}
