package br.com.testedx.shoppingCart;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import br.com.testedx.BR;
import br.com.testedx.R;
import br.com.testedx.model.Sandwich;
import br.com.testedx.shoppingCart.listener.GetSandwichListener;
import br.com.testedx.shoppingCart.model.Order;
import br.com.testedx.util.ImageUtil;
import br.com.testedx.viewholder.ViewHolder;

/**
 * Created by rafaela on 28/06/2017.
 */

public class ShoppingCartAdapter extends RecyclerView.Adapter<ViewHolder> implements GetSandwichListener {

    private List<Order> sandwichList;
    private ShoppingCartContract.Presenter presenter;

    ShoppingCartAdapter(List<Order> sandwichList, ShoppingCartContract.Presenter presenter) {
        this.sandwichList = sandwichList;
        this.presenter = presenter;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopping_cart_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Order order = sandwichList.get(position);
        holder.getBinding().setVariable(BR.order, order);
        presenter.loadSandwichItem(order, holder, this);
    }

    @Override
    public int getItemCount() {
        return sandwichList.size();
    }

    @Override
    public void onSucessGetSandwich(Sandwich s, ViewHolder holder) {
        holder.getBinding().setVariable(BR.s, s);
    }


    @Override
    public void onErrorGetSandwich() {
    }

    @BindingAdapter("addImage")
    public static void addImage(ImageView v, String image) {
        ImageLoader.getInstance().displayImage(image, v, ImageUtil.getSandwichImageOptions());
    }
}
