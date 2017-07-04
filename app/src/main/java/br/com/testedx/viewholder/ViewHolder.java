package br.com.testedx.viewholder;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by rafaela on 01/07/2017.
 */

@SuppressWarnings("ALL")
public class ViewHolder extends RecyclerView.ViewHolder{

    private ViewDataBinding binding;

    public ViewHolder(View view) {
        super(view);
        setIsRecyclable(false);
        binding = DataBindingUtil.bind(view);
    }

    public ViewDataBinding getBinding() {
        return binding;
    }

}
