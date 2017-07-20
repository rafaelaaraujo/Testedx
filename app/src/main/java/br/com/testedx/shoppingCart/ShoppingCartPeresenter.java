package br.com.testedx.shoppingCart;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.testedx.enums.PromotionEnum;
import br.com.testedx.model.Ingredient;
import br.com.testedx.model.Sandwich;
import br.com.testedx.shoppingCart.listener.GetSandwichListener;
import br.com.testedx.shoppingCart.model.Order;
import br.com.testedx.java.util.Constants;
import br.com.testedx.java.util.retrofit.RetrofitManager;
import br.com.testedx.viewholder.ViewHolder;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by rafaela on 01/07/2017.
 */

class ShoppingCartPeresenter implements ShoppingCartContract.Presenter {

    private static final int NUN_PROMOTION_MEAT = 3;
    private static final int NUN_PROMOTION_CHEESE = 3;
    private static final double PROMOTION_LIGHT_PERCENT = 0.1;
    private ShoppingCartContract.View mShoppingCart;
    private HashMap<Integer, Ingredient> ingredientsList;

    ShoppingCartPeresenter(ShoppingCartContract.View mShoppingCart, HashMap<Integer, Ingredient> ingredientsList) {
        this.mShoppingCart = mShoppingCart;
        this.ingredientsList = ingredientsList;
    }

    @Override
    public void start() {
        loadCartItems();
    }

    @Override
    public void loadCartItems() {
        Call<List<Order>> call = RetrofitManager.getInstance().getClient().getCartItens();

        call.enqueue(new Callback<List<Order>>() {

            @Override
            public void onResponse(Call<List<Order>> call, retrofit2.Response<List<Order>> response) {
                if (response.isSuccessful()) {
                    List<Order> list = response.body();
                    if (list == null || list.isEmpty()) {
                        mShoppingCart.showEmpityMessage();
                    } else {
                        mShoppingCart.loadList(list);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable t) {
                mShoppingCart.showEmpityMessage();
            }
        });
    }

    @Override
    public void loadSandwichItem(final Order order, final ViewHolder holder, final GetSandwichListener listener) {
        Call<Sandwich> call = RetrofitManager.getInstance().getClient().getItem(String.valueOf(order.getId_sandwich()));

        call.enqueue(new Callback<Sandwich>() {
            @Override
            public void onResponse(Call<Sandwich> call, retrofit2.Response<Sandwich> response) {
                if (response.isSuccessful()) {
                    Sandwich s = response.body();
                    if (s != null && !order.getExtras().isEmpty())
                        s.setIngredients(order.getExtras());

                    listener.onSucessGetSandwich(updateTotalAndQuantity(s), holder);
                }
            }

            @Override
            public void onFailure(Call<Sandwich> call, Throwable t) {
                listener.onErrorGetSandwich();
            }
        });
    }

    /**
     * create string to show ingredits name and update price
     * based in ingredits and quantity of these ingredients
     *
     * @param sandwich sandwich that will be updated
     */
    private Sandwich updateTotalAndQuantity(Sandwich sandwich) {

        double total = Constants.ZERO;

        for (Map.Entry<Integer, Ingredient> entry : ingredientsList.entrySet()) {
            int occurrences = Collections.frequency(sandwich.getIngredients(), entry.getKey());
            if (occurrences > Constants.ZERO) {
                Ingredient i = entry.getValue();
                i.setQuantity(occurrences);
                sandwich.getIngredientsObj().put(i.getId(), i);
                sandwich.setIngredientsName(sandwich.getIngredientsName() + i.getName() + ",");
                total += i.getPrice() * occurrences;
            }
        }
        sandwich.setTotal(total);
        return addTotal(sandwich);
    }

    private Sandwich addTotal(Sandwich sandwich) {
        PromotionEnum promotionEnum = PromotionEnum.getPromtionType(sandwich);
        double totalWithDiscounts = applyDiscounts(promotionEnum, sandwich);

        sandwich.setTotalWithDiscounts(totalWithDiscounts);
        sandwich.setPromotionEnum(promotionEnum);

        return sandwich;
    }

    private double applyDiscounts(PromotionEnum promotionEnum, Sandwich s) {
        if (promotionEnum != null) {

            double total = s.getTotal();

            switch (promotionEnum) {
                case LIGHT:
                    total = getDiscountLight(s);
                    break;
                case CARNE:
                    total = getDiscountsMeat(s);
                    break;
                case QUEIJO:
                    total = getDiscountCheese(s);
                    break;
            }

            return total;
        }
        return s.getTotal();
    }

    private double getDiscountCheese(Sandwich s) {
        HashMap<Integer, Ingredient> ing = s.getIngredientsObj();
        if (ing.containsKey(PromotionEnum.CHEESE)) {
            int qtd = ing.get(PromotionEnum.CHEESE).getQuantity() / NUN_PROMOTION_CHEESE;
            return s.getTotal() - (ing.get(PromotionEnum.CHEESE).getPrice() * qtd);
        }
        return Constants.ZERO;
    }

    private double getDiscountsMeat(Sandwich s) {
        HashMap<Integer, Ingredient> ing = s.getIngredientsObj();
        if (ing.containsKey(PromotionEnum.HAMBURGUER_CARNE)) {
            int qtdDiscounts = ing.get(PromotionEnum.HAMBURGUER_CARNE).getQuantity() / NUN_PROMOTION_MEAT;
            return (s.getTotal() - (ing.get(PromotionEnum.HAMBURGUER_CARNE).getPrice() * qtdDiscounts));
        }
        return Constants.ZERO;
    }

    private double getDiscountLight(Sandwich s) {
        return s.getTotal() - (s.getTotal() * PROMOTION_LIGHT_PERCENT);
    }
}
