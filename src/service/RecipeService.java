package service;

import model.Category;
import model.Ingredient;
import model.Recipe;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class RecipeService {
    public static List<Recipe> findByIngredient(List<Recipe> recipes, String ingredient){
        return recipes.stream()
                .filter(a -> a.getIngredients().stream()
                        .anyMatch(i -> i.getName().equalsIgnoreCase(ingredient)))
                .collect(Collectors.toList());
    }

    public static Map<Category, List<Recipe>> groupByCategory(List<Recipe> recipes){
        return recipes.stream()
                .collect(Collectors
                        .groupingBy(Recipe:: getCategory,
                                Collectors.toList()));
    }
    public static Optional<Recipe> findMostDifficult(List<Recipe> recipes){
        return recipes.stream()
                .max(Comparator.comparing(Recipe::getDifficulty));

    }
    public static Map<Category, Long> countByCategory(List<Recipe> recipes){
        return recipes.stream()
                .collect(Collectors.groupingBy(Recipe::getCategory,
                        Collectors.counting()));
    }
    public static List<Recipe> sortByDifficulty(List<Recipe> recipes){
        return recipes.stream()
                .sorted(Comparator.comparing(Recipe::getDifficulty))
                .collect(Collectors.toList());
    }
    public static void saveToFile(List<Recipe> recipes, String fileName){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))){
            bw.write("Recepies\n\n");
            for (Recipe r : recipes){
                bw.write(r.toString());
                bw.write("\n\n");
            }
        } catch (IOException e){
            System.out.println("An error occurred while saving recipes: \n" + e.getMessage());
        }
    }
    public static List<Recipe> downloadFromFile(String fileName){
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            String name = null;
            Category category = null;
            Integer difficulty = null;
            List<Recipe> recipes = new ArrayList<>();
            List<Ingredient> ingredients = new ArrayList<>();
            while((line = br.readLine()) != null) {
                if(line.isEmpty()){
                    Recipe r = new Recipe(name,ingredients, category, difficulty);
                    recipes.add(r);
                    name = null;
                    category = null;
                    difficulty = null;
                    ingredients.clear();
                } else if (line.matches("^[a-zA-Z ]*\\d*")){
                    name = line;
                }else if( line.split(";").length == 3){
                    String[] i = line.split(";");
                    String ingredientName = i[0];
                    Double ingredientAmount = Double.parseDouble(i[1]);
                    String ingredientMeasure = i[2];
                    ingredients.add(new Ingredient(ingredientName, ingredientAmount, ingredientMeasure));
                }else if(line.startsWith("Difficulty: ")){
                    String[] d = line.split(": ");
                    difficulty = Integer.parseInt(d[1]);
                } else if(line.startsWith("Category: ")){
                    String[] c = line.split(": ");
                    category = Category.valueOf(c[1].toUpperCase());
                }
            }
            if (name != null && category != null && difficulty != null && !ingredients.isEmpty()) {
                Recipe r = new Recipe(name, ingredients, category, difficulty);
                recipes.add(r);
            }
            return recipes;
        }catch (IOException e) {
            System.out.println("jfjfjkkf");
            return null;
        }

    }
}
