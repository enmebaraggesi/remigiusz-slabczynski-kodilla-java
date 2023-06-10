package com.kodilla.patterns.builder.bigmac;

public enum Ingredient {

    LETTUCE("lettuce"),
    ONION("onion"),
    BACON("bacon"),
    CUCUMBER("cucumber"),
    CHILI("chili"),
    MUSHROOMS("mushrooms"),
    PRAWNS("prawns"),
    CHEESE("cheese");

    private final String ingredient;

    Ingredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getIngredient() {
        return ingredient;
    }
}
