package model;

import java.util.List;

public class Recipe {
    private String name;
    private List<Ingredient> ingredients;
    private Category category;
    private int difficulty;

    public Recipe(String name, List<Ingredient> ingredients, Category category, int difficulty) {
        this.name = name;
        this.ingredients = ingredients;
        this.category = category;
        this.difficulty = difficulty;
    }

    public String getName() {
        return name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public Category getCategory() {
        return category;
    }

    public int getDifficulty() {
        return difficulty;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(":\n");
        for (Ingredient i : ingredients){
            sb.append(" - ").append(i).append("\n");
        }
        sb.append("Category: ").append(category).append("\n");
        sb.append("Difficulty: ").append(difficulty);
        return  sb.toString();
//                name + ":\n" +
//                ingredients +
//                "\n" + category +
//                ", difficulty=" + difficulty;
    }
}
