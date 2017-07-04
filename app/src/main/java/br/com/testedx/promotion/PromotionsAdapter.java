package br.com.testedx.promotion;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.testedx.BR;
import br.com.testedx.R;
import br.com.testedx.promotion.model.Promotion;
import br.com.testedx.viewholder.ViewHolder;

/**
 * Created by rafaela on 28/06/2017.
 */

class PromotionsAdapter extends RecyclerView.Adapter<ViewHolder> {

    private final List<Promotion> mValues;

    PromotionsAdapter(List<Promotion> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_promotions, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.getBinding().setVariable(BR.promotion, mValues.get(position));
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

}
