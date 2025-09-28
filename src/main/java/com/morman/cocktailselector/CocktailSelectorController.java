package com.morman.cocktailselector;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/cocktails")
public class CocktailSelectorController {

    private final CocktailSelectorRepository repository;

    public CocktailSelectorController(CocktailSelectorRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("cocktails", repository.findAll());
        return "cocktails/index";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("cocktail", new CocktailSelector());
        model.addAttribute("title", "Create Cocktail");
        return "cocktails/form";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute("cocktail") CocktailSelector cocktail,
                         BindingResult bindingResult,
                         RedirectAttributes ra) {
        if (bindingResult.hasErrors()) {
            return "cocktails/form";
        }
        repository.save(cocktail);
        ra.addFlashAttribute("message", "Cocktail created successfully.");
        return "redirect:/cocktails";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable Long id, Model model, RedirectAttributes ra) {
        Optional<CocktailSelector> opt = repository.findById(id);
        if (opt.isEmpty()) {
            ra.addFlashAttribute("error", "Cocktail not found.");
            return "redirect:/cocktails";
        }
        model.addAttribute("cocktail", opt.get());
        return "cocktails/view";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model, RedirectAttributes ra) {
        Optional<CocktailSelector> opt = repository.findById(id);
        if (opt.isEmpty()) {
            ra.addFlashAttribute("error", "Cocktail not found.");
            return "redirect:/cocktails";
        }
        model.addAttribute("cocktail", opt.get());
        model.addAttribute("title", "Edit Cocktail");
        return "cocktails/form";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id,
                         @Valid @ModelAttribute("cocktail") CocktailSelector form,
                         BindingResult bindingResult,
                         RedirectAttributes ra) {
        if (bindingResult.hasErrors()) {
            return "cocktails/form";
        }
        return repository.findById(id).map(existing -> {
            existing.setIngredient1(form.getIngredient1());
            existing.setIngredient2(form.getIngredient2());
            existing.setIngredient3(form.getIngredient3());
            existing.setInstruction1(form.getInstruction1());
            existing.setInstruction2(form.getInstruction2());
            existing.setInstruction3(form.getInstruction3());
            repository.save(existing);
            ra.addFlashAttribute("message", "Cocktail updated successfully.");
            return "redirect:/cocktails";
        }).orElseGet(() -> {
            ra.addFlashAttribute("error", "Cocktail not found.");
            return "redirect:/cocktails";
        });
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes ra) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            ra.addFlashAttribute("message", "Cocktail deleted.");
        } else {
            ra.addFlashAttribute("error", "Cocktail not found.");
        }
        return "redirect:/cocktails";
    }
}
