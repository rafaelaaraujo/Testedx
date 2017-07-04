package br.com.testedx.enums;

import java.util.HashMap;

import br.com.testedx.model.Ingredient;
import br.com.testedx.model.Sandwich;

/**
 * Created by rafaela on 01/07/2017.
 */

public enum PromotionEnum {

    LIGHT, CARNE, QUEIJO, NONE;


    private static  final int ALFACE = 1;
    public static final int HAMBURGUER_CARNE = 3;
    public static final int CHEESE = 5;

    public static PromotionEnum getPromtionType(Sandwich s){
        HashMap<Integer,Ingredient> mapIngredients = s.getIngredientsObj();
        if(isPromotionLight(mapIngredients)){
            return PromotionEnum.LIGHT;

        }else if(isPromotionMeat(mapIngredients)){
            return PromotionEnum.CARNE;

        }else if(isPromotionCheese(mapIngredients)){
            return PromotionEnum.QUEIJO;
        }
        return PromotionEnum.NONE;
    }

    private static boolean isPromotionCheese(HashMap<Integer, Ingredient> mapIngredients) {
        return (mapIngredients.containsKey(CHEESE) && mapIngredients.get(CHEESE).getQuantity() >= 3);
    }

    private static boolean isPromotionMeat(HashMap<Integer, Ingredient> mapIngredients) {
        return (mapIngredients.containsKey(HAMBURGUER_CARNE) && mapIngredients.get(HAMBURGUER_CARNE).getQuantity() >= 3);
    }

    private static boolean isPromotionLight(HashMap<Integer,Ingredient> mapIngredients) {
        return (mapIngredients.containsKey(ALFACE) && !mapIngredients.containsKey(HAMBURGUER_CARNE));
    }
}
