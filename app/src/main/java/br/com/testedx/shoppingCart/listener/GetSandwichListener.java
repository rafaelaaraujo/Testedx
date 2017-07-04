package br.com.testedx.shoppingCart.listener;

import br.com.testedx.model.Sandwich;
import br.com.testedx.viewholder.ViewHolder;

/**
 * Created by rafaela on 01/07/2017.
 */

@SuppressWarnings("ALL")
public interface GetSandwichListener {

    void onSucessGetSandwich(Sandwich s, ViewHolder holder);

    void onErrorGetSandwich();
}
