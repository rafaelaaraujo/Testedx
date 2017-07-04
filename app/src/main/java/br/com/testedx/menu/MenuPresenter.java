package br.com.testedx.menu;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.testedx.R;
import br.com.testedx.editOrder.EditOrderDialogFragment;
import br.com.testedx.model.Ingredient;
import br.com.testedx.model.Sandwich;
import br.com.testedx.util.Constants;
import br.com.testedx.util.volley.CustomRequest;
import br.com.testedx.util.volley.VolleyHelper;

/**
 * Created by rafaela on 28/06/2017.
 */

@SuppressWarnings("ALL")
class MenuPresenter implements MenuContract.Presenter {

    private static final String ITEM_EDITED_IDENTIFIER = " - do seu jeito";
    private final MenuContract.View mSandwichView;
    private ArrayList<Sandwich> sandwiches = new ArrayList<>();
    private HashMap<Integer, Ingredient> ingredientsList;

    MenuPresenter(@NonNull MenuContract.View mSandwichView, HashMap<Integer, Ingredient> ingredientsList) {
        this.mSandwichView = mSandwichView;
        this.ingredientsList = ingredientsList;
    }

    @Override
    public void openOrderDetail(FragmentManager fm, Sandwich sadwich) {
        EditOrderDialogFragment editOrderDialogFragment = new EditOrderDialogFragment();
        Bundle args = new Bundle();
        args.putParcelable(Constants.SANDWICH, sadwich);
        args.putSerializable(Constants.INGREDIENTS, ingredientsList);
        editOrderDialogFragment.setArguments(args);
        editOrderDialogFragment.show(fm, "Order detail");
    }

    @Override
    public void loadMenu() {
        mSandwichView.showLoading(R.string.search_menu);
        String url = Constants.URL_BASE + "/lanche/";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, sucessLoadSandwiches, errorLoadSandwichs);
        VolleyHelper.getInstance().addToRequestQueue(request);
    }


    @Override
    public void updateIngredientsName(Sandwich sandwich) {
        StringBuilder ingredients = new StringBuilder();
        for (Map.Entry<Integer, Ingredient> entry : sandwich.getIngredientsObj().entrySet()) {
            ingredients.append(entry.getValue().getName()).append(Constants.COMMA_STRING);
        }
        sandwich.setIngredientsName(ingredients.toString());
    }

    @Override
    public void updateItem(Sandwich s) {
        upgrateName(s);
        updateIngredientsName(s);
        sandwiches.set(s.getId() - 1, s);
        addItemToCart(s);
    }

    private void upgrateName(Sandwich s) {
        if (!s.getName().contains(ITEM_EDITED_IDENTIFIER))
            s.setName(s.getName() + ITEM_EDITED_IDENTIFIER);
    }

    @Override
    public void addItemToCart(Sandwich s) {
        mSandwichView.showLoading(R.string.add_cart);
        String url = Constants.URL_BASE + "/pedido/" + s.getId();
        CustomRequest request = new CustomRequest(Request.Method.PUT, url, getParamAddCart(s), sucessAddCart, errorAddCart);
        VolleyHelper.getInstance().addToRequestQueue(request);
    }

    /**
     * add id of the ingredients as parameter repeats
     * id the number of time it was added
     *
     * @param s sandwich that will be added to the cart
     */
    private Map<String, String> getParamAddCart(Sandwich s) {
        List<Integer> list = new ArrayList();
        Map<String, String> param = new HashMap<>();
        for (Map.Entry<Integer, Ingredient> entry : s.getIngredientsObj().entrySet()) {
            for (int i = 0; i < entry.getValue().getQuantity(); i++) {
                list.add(entry.getKey());
            }
        }
        param.put("extras", list.toString());
        return param;

    }

    private Response.Listener<JSONObject> sucessAddCart = new Response.Listener<JSONObject>() {

        @Override
        public void onResponse(JSONObject response) {
            mSandwichView.dismissLoading();
            mSandwichView.showAlertMessage(R.string.sucess_add_cart);
        }
    };

    private Response.ErrorListener errorAddCart = new Response.ErrorListener() {

        @Override
        public void onErrorResponse(VolleyError error) {
            mSandwichView.dismissLoading();
            mSandwichView.showAlertMessage(R.string.error_add_cart);

        }
    };

    private Response.Listener<JSONArray> sucessLoadSandwiches = new Response.Listener<JSONArray>() {

        @Override
        public void onResponse(JSONArray response) {
            mSandwichView.dismissLoading();
            try {
                for (int i = 0; i < response.length(); ++i) {
                    Sandwich s = new Gson().fromJson(response.get(i).toString(), Sandwich.class);
                    addListIngredientsAndTotal(s);
                    sandwiches.add(s);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            mSandwichView.showSandwichs(sandwiches, ingredientsList);
        }
    };

    private void addListIngredientsAndTotal(Sandwich sandwich) {
        for (int ingredient : sandwich.getIngredients()) {
            Ingredient i = ingredientsList.get(ingredient);
            sandwich.addItemListIngredientsObj(i);
        }
    }

    private Response.ErrorListener errorLoadSandwichs = new Response.ErrorListener() {

        @Override
        public void onErrorResponse(VolleyError error) {
            mSandwichView.dismissLoading();
            mSandwichView.showAlertMessage(R.string.erro_search_menu);
        }
    };

    @Override
    public void start() {
        loadMenu();
    }

}
