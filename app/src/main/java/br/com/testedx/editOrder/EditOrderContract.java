package br.com.testedx.editOrder;

import java.util.HashMap;
import java.util.List;

import br.com.testedx.BasePresenter;
import br.com.testedx.BaseView;
import br.com.testedx.enums.PromotionEnum;
import br.com.testedx.main.MainActivity;
import br.com.testedx.model.Ingredient;

/**
 * Created by rafaela on 29/06/2017.
 */

class EditOrderContract {

    interface View extends BaseView<EditOrderContract.Presenter> {

        void addIngredientView(List<Ingredient> list, HashMap<Integer, Ingredient> ingredientsSandwich);

        void updateTotal(String total);

        void updateDiscounts(String totalWithDiscounts, String promotionEnum);

        void updateIngredients(String ingredients);
    }

    interface Presenter extends BasePresenter {

        void applyDiscounts();

        int loadValueIngredient(Ingredient item, int value, boolean plus);

        void updateTotalAndQuantity(Ingredient item, int value, boolean plus);

        void loadIngredientsOptions();
    }
}
