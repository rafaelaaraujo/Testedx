package br.com.testedx.editOrder;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.HashMap;
import java.util.List;

import br.com.testedx.BR;
import br.com.testedx.R;
import br.com.testedx.editOrder.listener.OnClickIngredientListener;
import br.com.testedx.model.Ingredient;
import br.com.testedx.util.Constants;
import br.com.testedx.util.ImageUtil;

/**
 * Created by rafaela.araujo on 30/06/2017.
 */

@SuppressWarnings("ALL")
public class EditOrderAdapter extends RecyclerView.Adapter<EditOrderAdapter.ViewHolder> {

    private List<Ingredient> ingredients;
    private OnClickIngredientListener listener;
    private static HashMap<Integer, Ingredient> ingredientsSandwich;

    EditOrderAdapter(List<Ingredient> ingredients, HashMap<Integer, Ingredient> ingredientsSandwich, OnClickIngredientListener listener) {
        this.ingredients = ingredients;
        this.listener = listener;
        this.ingredientsSandwich = ingredientsSandwich;
    }

    @Override
    public EditOrderAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.ingredients_item, parent, false);
        return new EditOrderAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(EditOrderAdapter.ViewHolder holder, int position) {
        holder.getBinding().setVariable(BR.ingredient, ingredients.get(position));
        holder.setIsRecyclable(false);
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private static final String MINUS_TAG = "minus";
        private static final String PLUS_TAG = "plus";
        private final ViewDataBinding binding;
        private final TextView qtd;

        ViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);

            itemView.findViewById(R.id.btn_minus).setOnClickListener(this);
            itemView.findViewById(R.id.btn_plus).setOnClickListener(this);
            qtd = (TextView) itemView.findViewById(R.id.txt_ingredient);
        }

        @Override
        public void onClick(View v) {
            String tag = String.valueOf(v.getTag());
            Ingredient i = ingredients.get(getAdapterPosition());

            if (tag != null) {
                if (tag.equals(MINUS_TAG)) {
                    listener.onIngredientMinusViewClick(i, qtd);
                } else if (tag.equals(PLUS_TAG)) {
                    listener.onIngredientPlusViewClick(i, qtd);
                }
            }
        }

        ViewDataBinding getBinding() {
            return binding;
        }
    }

    @BindingAdapter("addItemQuantity")
    public static void getQuantity(TextView v, Ingredient ing) {
        if (ingredientsSandwich.containsKey(ing.getId())) {
            v.setText(String.valueOf(ingredientsSandwich.get(ing.getId()).getQuantity()));
        } else {
            v.setText(Constants.ZERO_STRING);
        }
    }

    @BindingAdapter("addImageIngrediente")
    public static void addImageIngrediente(ImageView v, String image) {
        ImageLoader.getInstance().displayImage(image,v, ImageUtil.getIngredientsImageOptions());

    }
}
