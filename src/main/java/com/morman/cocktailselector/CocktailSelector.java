package com.morman.cocktailselector;

import jakarta.persistence.*;
import jakarta.validation.Valid;
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

    @Embedded
    @Valid
    private Ingredient ingredient1;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "ounces", column = @Column(name = "ingredient2_ounces")),
            @AttributeOverride(name = "liquid", column = @Column(name = "ingredient2_liquid"))
    })
    @Valid
    private Ingredient ingredient2;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "ounces", column = @Column(name = "ingredient3_ounces")),
            @AttributeOverride(name = "liquid", column = @Column(name = "ingredient3_liquid"))
    })
    @Valid
    private Ingredient ingredient3;

    @NotBlank
    private String instruction1;
    @NotBlank
    private String instruction2;
    @NotBlank
    private String instruction3;

    public CocktailSelector() {
        // default values using integer ounces as required
        this.ingredient1 = new Ingredient(2, "base spirit");
        this.ingredient2 = new Ingredient(1, "citrus");
        this.ingredient3 = new Ingredient(1, "sweetener");
        this.instruction1 = "Add all ingredients to a shaker with ice";
        this.instruction2 = "Shake until well chilled";
        this.instruction3 = "Strain into a chilled glass";
    }

    public CocktailSelector(Ingredient ingredient1, Ingredient ingredient2, Ingredient ingredient3,
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

    public Ingredient getIngredient1() { return ingredient1; }
    public void setIngredient1(Ingredient ingredient1) { this.ingredient1 = ingredient1; }
    public Ingredient getIngredient2() { return ingredient2; }
    public void setIngredient2(Ingredient ingredient2) { this.ingredient2 = ingredient2; }
    public Ingredient getIngredient3() { return ingredient3; }
    public void setIngredient3(Ingredient ingredient3) { this.ingredient3 = ingredient3; }

    public String getInstruction1() { return instruction1; }
    public void setInstruction1(String instruction1) { this.instruction1 = instruction1; }
    public String getInstruction2() { return instruction2; }
    public void setInstruction2(String instruction2) { this.instruction2 = instruction2; }
    public String getInstruction3() { return instruction3; }
    public void setInstruction3(String instruction3) { this.instruction3 = instruction3; }
}
