package com.morman.cocktailselector;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Embeddable
public class Ingredient {

    @Column(precision = 10, scale = 2)
    @DecimalMin(value = "0.00")
    @Digits(integer = 8, fraction = 2)
    private BigDecimal ounces;

    @NotBlank
    private String liquid;

    public Ingredient() {
    }

    public Ingredient(BigDecimal ounces, String liquid) {
        setOunces(ounces);
        this.liquid = liquid;
    }

    public BigDecimal getOunces() {
        return ounces;
    }

    public void setOunces(BigDecimal ounces) {
        if (ounces == null) {
            this.ounces = null;
        } else {
            this.ounces = ounces.setScale(2, RoundingMode.HALF_UP);
        }
    }

    public String getLiquid() {
        return liquid;
    }

    public void setLiquid(String liquid) {
        this.liquid = liquid;
    }

    @Override
    public String toString() {
        String oz = ounces == null ? "" : ounces.setScale(2, RoundingMode.HALF_UP).toPlainString();
        return oz + " oz " + (liquid == null ? "" : liquid);
    }
}
