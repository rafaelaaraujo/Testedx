package br.com.testedx.menu;

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
import br.com.testedx.menu.listener.OnRecyclerViewClickListener;
import br.com.testedx.model.Sandwich;
import br.com.testedx.util.ImageUtil;
import br.com.testedx.viewholder.ViewHolder;

/**
 * Created by rafaela on 28/06/2017.
 */

public class MenuAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<Sandwich> sandwichList;
    private OnRecyclerViewClickListener clickListener;

    MenuAdapter(List<Sandwich> sandwichList, OnRecyclerViewClickListener clickListener) {
        this.sandwichList = sandwichList;
        this.clickListener = clickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.sandwich_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.getBinding().setVariable(BR.sandwich, sandwichList.get(position));
        holder.getBinding().setVariable(BR.callback, clickListener);
        holder.getBinding().executePendingBindings();
        holder.setIsRecyclable(false);
    }

    @Override
    public int getItemCount() {
        return sandwichList.size();
    }


    @BindingAdapter("addImageMenu")
    public static void addImageMenu(ImageView v, String image) {
        ImageLoader.getInstance().displayImage(image,v, ImageUtil.getSandwichImageOptions());
    }
}
