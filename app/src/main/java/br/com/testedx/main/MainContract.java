package br.com.testedx.main;

import java.util.HashMap;

import br.com.testedx.BasePresenter;
import br.com.testedx.BaseView;
import br.com.testedx.model.Ingredient;

/**
 * Created by rafaela on 01/07/2017.
 */

class MainContract {
    interface View extends BaseView<MainContract.Presenter> {

        void showLoading(int message);

        void dismissLoading();

        void openShoppingCard(HashMap<Integer,Ingredient> ingredientHashMap);

        void showFragmentMenu(HashMap<Integer,Ingredient> ingredientHashMap);

        void initBottomNavigation();

        void showAlertMessage(int stringId);
    }

    interface Presenter extends BasePresenter {

        void loadIngredients();

        void openShoppingCard();

        void openFragmentMenu();
    }

}
