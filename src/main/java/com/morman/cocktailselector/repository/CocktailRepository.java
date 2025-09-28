package com.morman.cocktailselector.repository;

import com.morman.cocktailselector.model.Cocktail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CocktailRepository extends JpaRepository<Cocktail, Long> {
}
