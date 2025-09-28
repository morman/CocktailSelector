package com.morman.cocktailselector;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

@Embeddable
public class Ingredient {

    @PositiveOrZero
    private int ounces;

    @NotBlank
    private String liquid;

    public Ingredient() {
    }

    public Ingredient(int ounces, String liquid) {
        this.ounces = ounces;
        this.liquid = liquid;
    }

    public int getOunces() {
        return ounces;
    }

    public void setOunces(int ounces) {
        this.ounces = ounces;
    }

    public String getLiquid() {
        return liquid;
    }

    public void setLiquid(String liquid) {
        this.liquid = liquid;
    }

    @Override
    public String toString() {
        return ounces + " oz " + (liquid == null ? "" : liquid);
    }
}
