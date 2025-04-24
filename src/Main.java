import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Recipe> recipes = List.of(
                new Recipe("Chocolate Cake", List.of("flour", "sugar", "cocoa", "egg", "butter"), "dessert", 3),
                new Recipe("Pasta Carbonara", List.of("pasta", "egg", "cheese", "bacon"), "main", 2),
                new Recipe("Greek Salad", List.of("tomato", "cucumber", "feta", "olive oil"), "salad", 1),
                new Recipe("Lentil Soup", List.of("lentils", "carrot", "onion", "garlic"), "soup", 2),
                new Recipe("Cheesecake", List.of("cream cheese", "egg", "sugar", "cookies"), "dessert", 4),
                new Recipe("Omelette", List.of("egg", "cheese", "milk"), "breakfast", 1),
                new Recipe("Beef Stroganoff", List.of("beef", "onion", "sour cream", "mushroom"), "main", 4)
        );
//        System.out.println(filterByCategory("dessert", recipes));
//        System.out.println(findByIngredient(recipes, "egg"));
//        System.out.println(groupByCategory(recipes));
        System.out.println(findMostDifficult(recipes));

    }
    public static List<Recipe> filterByCategory(String category, List<Recipe> recipes){
        return recipes.stream()
                .filter(a -> a.getCategory().equals(category))
                .collect(Collectors.toList());

    }
    public static List<Recipe> findByIngredient(List<Recipe> recipes, String ingredient){
        return recipes.stream()
                .filter(a -> a.getIngredients().contains(ingredient))
                .collect(Collectors.toList());
    }

    public static Map<String, List<Recipe>> groupByCategory(List<Recipe> recipes){
        return recipes.stream()
                .collect(Collectors
                        .groupingBy(Recipe :: getCategory,
                        Collectors.toList()));
    }
    public static Optional<Recipe> findMostDifficult(List<Recipe> recipes){
        return recipes.stream()
                .max(Comparator.comparing(Recipe::getDifficulty));

    }
    public static Map<String, Long> countByCategory(List<Recipe> recipes){
        return recipes.stream()
                .collect(Collectors.groupingBy(Recipe::getCategory,
                        Collectors.counting()));
    }
}