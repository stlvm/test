import java.util.List;

public class Recipe {
    private String name;
    private List<String> ingredients;
    private String category;
    private int difficulty;

    public Recipe(String name, List<String> ingredients, String category, int difficulty) {
        this.name = name;
        this.ingredients = ingredients;
        this.category = category;
        this.difficulty = difficulty;
    }

    public String getName() {
        return name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getCategory() {
        return category;
    }

    public int getDifficulty() {
        return difficulty;
    }

    @Override
    public String toString() {
        return  name + ":\n" +
                 ingredients +
                "\n" + category +
                ", difficulty=" + difficulty;
    }
}
