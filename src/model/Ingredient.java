package model;

public class Ingredient {
    private String name;
    private double amount;
    private String measure;

    public Ingredient(String name, double amount, String measure) {
        this.name = name;
        this.amount = amount;
        this.measure = measure;
    }

    public Ingredient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public String getMeasure() {
        return measure;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" - ").append(amount).append(" ").append(measure);
        return sb.toString();
//        return name + " - " +
//                amount + " " +
//                measure;
    }
}
