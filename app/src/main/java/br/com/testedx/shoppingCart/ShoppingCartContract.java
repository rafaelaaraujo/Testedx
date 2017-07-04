package br.com.testedx.shoppingCart;

import java.util.HashMap;
import java.util.List;

import br.com.testedx.BasePresenter;
import br.com.testedx.BaseView;
import br.com.testedx.model.Ingredient;
import br.com.testedx.shoppingCart.listener.GetSandwichListener;
import br.com.testedx.shoppingCart.model.Order;
import br.com.testedx.viewholder.ViewHolder;

/**
 * Created by rafaela on 01/07/2017.
 */

class ShoppingCartContract {

    interface View extends BaseView<ShoppingCartContract.Presenter> {

        void loadList(List<Order> sandwiches);

        void showEmpityMessage();
    }

    interface Presenter extends BasePresenter {

        void loadCartItems();

        void loadSandwichItem(Order order, ViewHolder holder, GetSandwichListener listener);
    }
}
