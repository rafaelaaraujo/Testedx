package br.com.testedx.editOrder.listener;

import android.widget.TextView;

import br.com.testedx.model.Ingredient;

/**
 * Created by rafaela on 29/06/2017.
 */

@SuppressWarnings("ALL")
public interface OnClickIngredientListener {

    void onIngredientMinusViewClick(Ingredient ingredient, TextView tv);

    void onIngredientPlusViewClick(Ingredient ingredient, TextView tv);

    void onCancelListener();

    void onFinishListener();
}
