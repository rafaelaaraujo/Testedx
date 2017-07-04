package br.com.testedx.shoppingCart;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.testedx.enums.PromotionEnum;
import br.com.testedx.model.Ingredient;
import br.com.testedx.model.Sandwich;
import br.com.testedx.shoppingCart.listener.GetSandwichListener;
import br.com.testedx.shoppingCart.model.Order;
import br.com.testedx.util.Constants;
import br.com.testedx.util.volley.VolleyHelper;
import br.com.testedx.viewholder.ViewHolder;

/**
 * Created by rafaela on 01/07/2017.
 */

@SuppressWarnings("ALL")
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
        String url = Constants.URL_BASE + "/pedido/";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, sucessLoadItem, errorLoadItem);
        VolleyHelper.getInstance().addToRequestQueue(request);
    }

    @Override
    public void loadSandwichItem(final Order order, final ViewHolder holder, final GetSandwichListener listener) {
        String url = Constants.URL_BASE + "/lanche/" + order.getId_sandwich();
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Sandwich s = new Gson().fromJson(response.toString(), Sandwich.class);
                if (!order.getExtras().isEmpty())
                    s.setIngredients(order.getExtras());

                listener.onSucessGetSandwich(updateTotalAndQuantity(s), holder);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onErrorGetSandwich();
            }
        });
        VolleyHelper.getInstance().addToRequestQueue(request);

    }

    /**
     * create string to show ingredits name and update price
     * based in ingredits and quantity of these ingredients
     * @param sandwich sandwich that will be updated
     */
    private Sandwich updateTotalAndQuantity(Sandwich sandwich) {

        double total = Constants.ZERO;

        for (Map.Entry<Integer, Ingredient> entry : ingredientsList.entrySet()) {
            int occurrences = Collections.frequency(sandwich.getIngredients(), entry.getKey());
            if (occurrences >  Constants.ZERO) {
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
        double totalWithDiscounts = applyDiscounts(promotionEnum, sandwich.getTotal());

        sandwich.setTotalWithDiscounts(totalWithDiscounts);
        sandwich.setPromotionEnum(promotionEnum);

        return sandwich;
    }

    private double applyDiscounts(PromotionEnum promotionEnum, double total) {
        if (promotionEnum != null) {
            switch (promotionEnum) {
                case LIGHT:
                    return total - (total * PROMOTION_LIGHT_PERCENT);
                case CARNE:
                    int qtdDiscounts = ingredientsList.get(PromotionEnum.HAMBURGUER_CARNE).getQuantity() / NUN_PROMOTION_MEAT;
                    return (total - (ingredientsList.get(PromotionEnum.HAMBURGUER_CARNE).getPrice() * qtdDiscounts));
                case QUEIJO:
                    int qtd = ingredientsList.get(PromotionEnum.CHEESE).getQuantity() / NUN_PROMOTION_CHEESE;
                    total = total - (ingredientsList.get(PromotionEnum.CHEESE).getPrice() * qtd);
                    break;
            }
        }
        return total;
    }

    private Response.Listener<JSONArray> sucessLoadItem = new Response.Listener<JSONArray>() {

        @Override
        public void onResponse(JSONArray response) {
            Type listType = new TypeToken<List<Order>>() {}.getType();
            List<Order> list = new Gson().fromJson(response.toString(), listType);
            if (list.isEmpty()) {
                mShoppingCart.showEmpityMessage();
            } else {
                mShoppingCart.loadList(list, ingredientsList);
            }
        }
    };

    private Response.ErrorListener errorLoadItem = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            mShoppingCart.showEmpityMessage();
        }
    };
}
