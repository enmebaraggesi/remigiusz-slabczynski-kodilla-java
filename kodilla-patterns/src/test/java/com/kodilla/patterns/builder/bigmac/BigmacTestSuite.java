package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BigmacTestSuite {

    @Test
    void testBigmacBuilder() {

        //Given
        Bigmac tested = new Bigmac.BigmacBuilder()
            .bun(Bun.SESAME)
            .burgers(2)
            .sauce(Sauce.BBQ)
            .ingredient(Ingredient.BACON)
            .ingredient(Ingredient.CHEESE)
            .build();
        System.out.println(tested);

        //When
        int numberOfIngredients = tested.getIngredients().size();
        String typeOfSauce = tested.getSauce();

        //Then
        assertEquals(2, numberOfIngredients);
        assertEquals("barbecue", typeOfSauce);
    }
}