package com.morman.cocktailselector.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cocktail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ElementCollection
    @CollectionTable(name = "cocktail_ingredients", joinColumns = @JoinColumn(name = "cocktail_id"))
    private List<Ingredient> ingredients = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "cocktail_directions", joinColumns = @JoinColumn(name = "cocktail_id"))
    @Column(name = "direction")
    private List<String> directions = new ArrayList<>();

    public Cocktail() {
    }

    public Cocktail(String name, List<Ingredient> ingredients, List<String> directions) {
        this.name = name;
        if (ingredients != null) this.ingredients = ingredients;
        if (directions != null) this.directions = directions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getDirections() {
        return directions;
    }

    public void setDirections(List<String> directions) {
        this.directions = directions;
    }
}
