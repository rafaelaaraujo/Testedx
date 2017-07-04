package br.com.testedx.editOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import br.com.testedx.enums.PromotionEnum;
import br.com.testedx.main.MainActivity;
import br.com.testedx.model.Ingredient;
import br.com.testedx.model.Sandwich;
import br.com.testedx.util.Constants;
import br.com.testedx.util.StringUtil;

/**
 * Created by rafaela on 29/06/2017.
 */

@SuppressWarnings("ALL")
class EditOrderPresenter implements EditOrderContract.Presenter {

    private static final int NUN_PROMOTION_MEAT = 3;
    private static final int NUN_PROMOTION_CHEESE = 3;
    private static final double PROMOTION_LIGHT_PERCENT = 0.1;
    private EditOrderContract.View mOrderView;
    private Sandwich sandwich;
    private HashMap<Integer, Ingredient> ingredientsList = new HashMap<>();

    EditOrderPresenter(EditOrderContract.View view, Sandwich sandwich, HashMap<Integer, Ingredient> ingredientsList) {
        this.mOrderView = view;
        this.sandwich = sandwich;
        this.ingredientsList = ingredientsList;
    }

    @Override
    public void start() {
        loadIngredientsOptions();
    }

    private void updateIngredientsName() {
        StringBuilder ingredients = new StringBuilder();
        for (Map.Entry<Integer, Ingredient> entry : sandwich.getIngredientsObj().entrySet()) {
            ingredients.append(entry.getValue().getName()).append(Constants.COMMA_STRING);
        }
        sandwich.setIngredientsName(ingredients.toString());
        mOrderView.updateIngredients(ingredients.toString());
    }

    @Override
    public void applyDiscounts() {
        PromotionEnum promotionEnum = PromotionEnum.getPromtionType(sandwich);
        double totalDiscounts = sandwich.getTotal();

        if (promotionEnum != null) {
            switch (promotionEnum) {
                case LIGHT:
                    totalDiscounts = totalDiscounts - (totalDiscounts * PROMOTION_LIGHT_PERCENT);
                case CARNE:
                    int qtdDiscounts = ingredientsList.get(PromotionEnum.HAMBURGUER_CARNE).getQuantity() / NUN_PROMOTION_MEAT;
                    totalDiscounts = (totalDiscounts - (ingredientsList.get(PromotionEnum.HAMBURGUER_CARNE).getPrice() * qtdDiscounts));
                case QUEIJO:
                    int qtd = ingredientsList.get(PromotionEnum.CHEESE).getQuantity() / NUN_PROMOTION_CHEESE;
                    totalDiscounts = totalDiscounts - (ingredientsList.get(PromotionEnum.CHEESE).getPrice() * qtd);
                    break;
            }
        }
        mOrderView.updateDiscounts(StringUtil.formatNumberToCurrent(totalDiscounts), promotionEnum != PromotionEnum.NONE ? promotionEnum.toString() : null);
        sandwich.setTotalWithDiscounts(totalDiscounts);
        sandwich.setPromotionEnum(PromotionEnum.NONE);
    }

    @Override
    public void finishOrder(MainActivity activity) {
        activity.finishEditOrder(sandwich);
    }

    @Override
    public int loadValueIngredient(Ingredient item, int value, boolean plus) {
        value = plus ? value + Constants.ONE : value - Constants.ONE;
        updateTotalAndQuantity(item, value, plus);
        return (value < Constants.ZERO ? Constants.ZERO : value);
    }

    @Override
    public void updateTotalAndQuantity(Ingredient item, int value, boolean plus) {
        double total = sandwich.getTotal();

        if (plus) {
            total += item.getPrice();
            addSandwichIngredients(item);

        } else if (value > -1) {
            total -= item.getPrice();
            removeSandwichIngredients(item.getId(), value);
        }
        item.setQuantity(value);
        addTotal(total);
        updateIngredientsName();
    }

    private void addTotal(double total) {
        applyDiscounts();
        sandwich.setTotal(total);
        mOrderView.updateTotal(StringUtil.formatNumberToCurrent(total));

    }

    private void addSandwichIngredients(Ingredient item) {
        sandwich.getIngredientsObj().put(item.getId(), item);
    }

    private void removeSandwichIngredients(int item, int value) {
        if (value == 0) {
            sandwich.getIngredientsObj().remove(item);
        }
    }

    @Override
    public void loadIngredientsOptions() {
        mOrderView.addIngredientView(new ArrayList<>(ingredientsList.values()), sandwich.getIngredientsObj());
    }
}
