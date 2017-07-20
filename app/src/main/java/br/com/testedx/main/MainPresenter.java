package br.com.testedx.main;

import java.util.HashMap;
import java.util.List;

import br.com.testedx.R;
import br.com.testedx.model.Ingredient;
import br.com.testedx.java.util.retrofit.RetrofitManager;
import retrofit2.Call;
import retrofit2.Callback;

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

        Call<List<Ingredient>> call = RetrofitManager.getInstance().getClient().getIngredients();

        call.enqueue(new Callback<List<Ingredient>>() {

            @Override
            public void onResponse(Call<List<Ingredient>> call, retrofit2.Response<List<Ingredient>> response) {

                for (Ingredient ingredient : response.body()) {
                    ingredientsList.put(ingredient.getId(),ingredient);
                }
                mMainView.dismissLoading();
                mMainView.initBottomNavigation();
            }

            @Override
            public void onFailure(Call<List<Ingredient>> call, Throwable t) {
                mMainView.dismissLoading();
                mMainView.showAlertMessage(R.string.erro_search_menu);
            }
        });
    }

    @Override
    public void openShoppingCard() {
        mMainView.openShoppingCard(ingredientsList);
    }

    @Override
    public void openFragmentMenu() {
        mMainView.showFragmentMenu(ingredientsList);
    }

}
