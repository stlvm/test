package model;

public enum Category {
    BREAKFAST,
    DESSERT,
    LUNCH;
    @Override
    public String toString() {
        String lowercase = name().toLowerCase();
        return Character.toUpperCase(lowercase.charAt(0)) + lowercase.substring(1);
    }
}
