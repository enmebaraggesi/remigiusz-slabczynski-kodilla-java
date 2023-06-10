package com.kodilla.patterns.builder.bigmac;

import java.util.*;

public class Bigmac {

    private String bun;
    private int burgers;
    private String sauce;
    private List<String> ingredients;

    private Bigmac(String bun, int burgers, String sauce, List<String> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public String getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Bigmac{" +
            "bun='" + bun + '\'' +
            ", burgers=" + burgers +
            ", sauce='" + sauce + '\'' +
            ", ingredients=" + ingredients +
            '}';
    }

    public static class BigmacBuilder {

        private String bun;
        private int burgers;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        public BigmacBuilder bun(Bun bun) {
            this.bun = bun.getBun();
            return this;
        }

        public BigmacBuilder burgers(int quantity) {
            this.burgers = quantity;
            return this;
        }

        public BigmacBuilder sauce(Sauce sauce) {
            this.sauce = sauce.getSauce();
            return this;
        }

        public BigmacBuilder ingredient(Ingredient ingredient) {
            ingredients.add(ingredient.getIngredient());
            return this;
        }

        public Bigmac build() {
            return new Bigmac(bun, burgers, sauce, ingredients);
        }
    }
}
