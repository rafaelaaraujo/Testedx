package br.com.testedx.menu;

import android.app.FragmentManager;

import java.util.HashMap;
import java.util.List;

import br.com.testedx.BasePresenter;
import br.com.testedx.BaseView;
import br.com.testedx.model.Ingredient;
import br.com.testedx.model.Sandwich;

/**
 * Created by rafaela on 28/06/2017.
 */

public interface MenuContract {

    interface View extends BaseView<Presenter>{

        void showSandwichs(List<Sandwich> sandwichList, HashMap<Integer, Ingredient> ingredientsList);

        void showAlertMessage(int message);

        void dismissAlertMessage();

        void finishCustomizerItem(Sandwich s);

        void updateMenuItem(Sandwich s);

    }

    interface Presenter extends BasePresenter {

        void openOrderDetail(FragmentManager fm, Sandwich sandwich);

        void loadMenu();

        void updateIngredientsName(Sandwich sandwich);

        void updateItem(Sandwich s);

        void addItemToCart(Sandwich s);
    }
}