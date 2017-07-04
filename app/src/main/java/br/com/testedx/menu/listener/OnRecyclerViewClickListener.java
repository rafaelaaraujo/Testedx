package br.com.testedx.menu.listener;

import br.com.testedx.model.Sandwich;

/**
 * Created by rafaela on 29/06/2017.
 */

public interface OnRecyclerViewClickListener {

    void addCart(Sandwich clickedObject);

    void editOrder(Sandwich clickedObject);
}
