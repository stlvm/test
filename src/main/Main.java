package main;

import model.*;
import service.RecipeService;

import java.util.*;
import java.util.stream.Collectors;

import static service.RecipeService.*;

public class Main {
    public static void main(String[] args) {
//        List<Recipe> recipes = List.of(
//                new Recipe("Chocolate Cake", List.of("flour", "sugar", "cocoa", "egg", "butter"), "dessert", 3),
//                new Recipe("Pasta Carbonara", List.of("pasta", "egg", "cheese", "bacon"), "main", 2),
//                new Recipe("Greek Salad", List.of("tomato", "cucumber", "feta", "olive oil"), "salad", 1),
//                new Recipe("Lentil Soup", List.of("lentils", "carrot", "onion", "garlic"), "soup", 2),
//                new Recipe("Cheesecake", List.of("cream cheese", "egg", "sugar", "cookies"), "dessert", 4),
//                new Recipe("Omelette", List.of("egg", "cheese", "milk"), "breakfast", 1),
//                new Recipe("Beef Stroganoff", List.of("beef", "onion", "sour cream", "mushroom"), "main", 4)
//        );
//        System.out.println(filterByCategory("dessert", recipes));
//        System.out.println(findByIngredient(recipes, "egg"));
//        System.out.println(groupByCategory(recipes));
//        System.out.println(findMostDifficult(recipes));
        List<Recipe> recipes = List.of(
                new Recipe(
                        "Pancakes",
                        List.of(
                                new Ingredient("Flour", 200, "g"),
                                new Ingredient("Milk", 250, "ml"),
                                new Ingredient("Egg", 2, "pcs"),
                                new Ingredient("Sugar", 1, "tbsp")
                        ),
                        Category.BREAKFAST,
                        2
                ),
                new Recipe(
                        "Scrambled Eggs",
                        List.of(
                                new Ingredient("Egg", 3, "pcs"),
                                new Ingredient("Butter", 10, "g"),
                                new Ingredient("Salt", 1, "tsp")
                        ),
                        Category.BREAKFAST,
                        1
                ),
                new Recipe(
                        "Simple Salad",
                        List.of(
                                new Ingredient("Tomato", 2, "pcs"),
                                new Ingredient("Cucumber", 1, "pcs"),
                                new Ingredient("Olive oil", 1, "tbsp"),
                                new Ingredient("Salt", 1, "tsp")
                        ),
                        Category.LUNCH,
                        1
                ),
                new Recipe(
                        "Chocolate Cake",
                        List.of(
                                new Ingredient("Flour", 300, "g"),
                                new Ingredient("Cocoa powder", 50, "g"),
                                new Ingredient("Egg", 3, "pcs"),
                                new Ingredient("Sugar", 150, "g"),
                                new Ingredient("Butter", 100, "g")
                        ),
                        Category.DESSERT,
                        4
                )
        );
        Map<Category, List<Recipe>> recipesGrouped = groupByCategory(recipes);

//        for(Map.Entry<Category,List<Recipe>> rg : recipesGrouped.entrySet()){
//            System.out.println(rg.getKey() + ":\n" + rg.getValue());
//        }
//
//        saveToFile(recipes, "testSave.txt");
        List<Recipe> recipes1 = downloadFromFile("recipes.txt");
//        for (Recipe r : recipes1){
//            System.out.println(r);
//        }
//        recipes.addAll(recipes1);

        recipes.stream()
                .filter(a -> a.getCategory().equals(Category.BREAKFAST) && (a.getDifficulty() <= 2))
                .filter(a -> a.getIngredients().stream()
                        .anyMatch((i -> i.getName().equalsIgnoreCase("egg"))))
                .sorted(Comparator.comparing(Recipe::getDifficulty))
                .forEach(a -> System.out.println(a.getName() +
                        " " + a.getCategory() +
                        " " + a.getDifficulty()));

    }
}