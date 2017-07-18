package br.com.testedx.menu;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;

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
import br.com.testedx.util.retrofit.RetrofitManager;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by rafaela on 28/06/2017.
 */

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
        editOrderDialogFragment.setCancelable(false);
        editOrderDialogFragment.show(fm, "Order detail");
    }

    @Override
    public void loadMenu() {
        mSandwichView.showLoading(R.string.search_menu);
        Call<List<Sandwich>> call = RetrofitManager.getInstance().getClient().getSandwichs();

        call.enqueue(new Callback<List<Sandwich>>() {

            @Override
            public void onResponse(Call<List<Sandwich>> call, retrofit2.Response<List<Sandwich>> response) {
                mSandwichView.dismissLoading();

                for (Sandwich sandwich : response.body()) {
                    addListIngredientsAndTotal(sandwich);
                }

                sandwiches.addAll(response.body());
                mSandwichView.showSandwichs(sandwiches, ingredientsList);
            }

            @Override
            public void onFailure(Call<List<Sandwich>> call, Throwable t) {
                mSandwichView.dismissLoading();
                mSandwichView.showAlertMessage(R.string.erro_search_menu);
            }
        });
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
        updateName(s);
        updateIngredientsName(s);
        sandwiches.set(s.getId() - 1, s);
    }

    private void updateName(Sandwich s) {
        if (!s.getName().contains(ITEM_EDITED_IDENTIFIER))
            s.setName(s.getName() + ITEM_EDITED_IDENTIFIER);
    }

    @Override
    public void addItemToCart(Sandwich s) {
        if(s.getTotal() != Constants.ZERO) {
            mSandwichView.showLoading(R.string.add_cart);

            Call<JSONObject> call = RetrofitManager.getInstance().getClient().addItemToCart(String.valueOf(s.getId()),getParamAddCart(s));

            call.enqueue(new Callback<JSONObject>() {

                @Override
                public void onResponse(Call<JSONObject> call, retrofit2.Response<JSONObject> response) {
                    if(response.isSuccessful()) {
                        mSandwichView.dismissLoading();
                        mSandwichView.showAlertMessage(R.string.sucess_add_cart);
                    }else{
                        mSandwichView.dismissLoading();
                        mSandwichView.showAlertMessage(R.string.error_add_cart);
                    }
                }

                @Override
                public void onFailure(Call<JSONObject> call, Throwable t) {
                    mSandwichView.dismissLoading();
                    mSandwichView.showAlertMessage(R.string.error_add_cart);
                }
            });
        }else{
            mSandwichView.showAlertMessage(R.string.add_cart_error);
        }
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

    private void addListIngredientsAndTotal(Sandwich sandwich) {
        for (int ingredient : sandwich.getIngredients()) {
            Ingredient i = ingredientsList.get(ingredient);
            try {
                sandwich.addItemListIngredientsObj(i);
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void start() {
        loadMenu();
    }
}
