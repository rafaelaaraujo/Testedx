package br.com.testedx.main;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.HashMap;

import br.com.testedx.R;
import br.com.testedx.model.Ingredient;
import br.com.testedx.util.Constants;
import br.com.testedx.util.volley.VolleyHelper;

/**
 * Created by rafaela on 01/07/2017.
 */

class MainPresenter implements MainContract.Presenter {

    private MainContract.View mMainView;
    private HashMap<Integer, Ingredient> ingredientsList = new HashMap<>();

    MainPresenter(MainContract.View mMainView) {
        this.mMainView = mMainView;
    }

    @Override
    public void start() {
        loadIngredients();
    }

    @Override
    public void loadIngredients() {
        mMainView.showLoading(R.string.waiting);
        String url = Constants.URL_BASE + "/ingrediente/";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, sucessLoadIngredients, errorLoadIngredients);
        VolleyHelper.getInstance().addToRequestQueue(request);
    }

    @Override
    public void openShoppingCard() {
        mMainView.openShoppingCard(ingredientsList);
    }

    @Override
    public void openFragmentMenu() {
        mMainView.showFragmentMenu(ingredientsList);
    }

    private Response.Listener<JSONArray> sucessLoadIngredients = new Response.Listener<JSONArray>() {

        @Override
        public void onResponse(JSONArray response) {
            try {
                for (int i = 0; i < response.length(); ++i) {
                    Ingredient ingredient = new Gson().fromJson(response.get(i).toString(), Ingredient.class);
                    ingredientsList.put(ingredient.getId(), ingredient);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            mMainView.dismissLoading();
            mMainView.initBottomNavigation();
        }
    };

    private Response.ErrorListener errorLoadIngredients = new Response.ErrorListener() {

        @Override
        public void onErrorResponse(VolleyError error) {
            mMainView.dismissLoading();
            mMainView.showAlertMessage(R.string.erro_search_menu);
        }
    };
}
