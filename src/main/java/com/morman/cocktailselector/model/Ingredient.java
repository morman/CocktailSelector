package com.morman.cocktailselector.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Ingredient {

    // e.g., "2 oz", "1 tsp"; keep as String for flexibility
    @Column(name = "quantity")
    private String quantity;

    // the ingredient name itself, e.g., "Vodka", "Lime Juice"
    @Column(name = "element")
    private String element;

    public Ingredient() {
    }

    public Ingredient(String quantity, String element) {
        this.quantity = quantity;
        this.element = element;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(quantity, that.quantity) &&
               Objects.equals(element, that.element);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, element);
    }

    @Override
    public String toString() {
        return (quantity != null ? quantity + " " : "") + (element != null ? element : "");
    }
}
