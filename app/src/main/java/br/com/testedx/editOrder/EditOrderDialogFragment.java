package br.com.testedx.editOrder;

import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.HashMap;
import java.util.List;

import br.com.testedx.R;
import br.com.testedx.databinding.FragmentEditorderBinding;
import br.com.testedx.editOrder.listener.OnClickIngredientListener;
import br.com.testedx.enums.PromotionEnum;
import br.com.testedx.main.MainActivity;
import br.com.testedx.model.Ingredient;
import br.com.testedx.model.Sandwich;
import br.com.testedx.util.Constants;
import br.com.testedx.util.ImageUtil;
import br.com.testedx.util.StringUtil;


/**
 * Created by rafaela on 29/06/2017.
 */

@SuppressWarnings("ALL")
public class EditOrderDialogFragment extends DialogFragment implements EditOrderContract.View, OnClickIngredientListener {

    private EditOrderContract.Presenter mOrderPresenter;
    private ProgressDialog pd;
    private View v;
    private FragmentEditorderBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Sandwich s = getArguments().getParcelable(Constants.SANDWICH);
        mOrderPresenter = new EditOrderPresenter(this, s, (HashMap<Integer, Ingredient>) getArguments().getSerializable(Constants.INGREDIENTS));
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_editorder, container, false);
        binding.setSandwich(s);
        binding.setCallback(this);
        if (s != null && s.getPromotionEnum() != PromotionEnum.NONE)
            updateDiscounts(StringUtil.formatNumberToCurrent(s.getTotalWithDiscounts()), s.getPromotionEnum().toString());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.v = view;
    }

    @Override
    public void addIngredientView(List<Ingredient> list, HashMap<Integer, Ingredient> ingredientsSandwich) {
        RecyclerView mRecyclerView = (RecyclerView) v.findViewById(R.id.recicle_edit_order);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        EditOrderAdapter mAdapter = new EditOrderAdapter(list, ingredientsSandwich, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void updateTotal(String total) {
        binding.setPrice(total);
    }

    @Override
    public void updateDiscounts(String totalWithDiscounts, String promotion) {
        binding.setPriceDiscount(totalWithDiscounts);
        binding.setPromotion(promotion);
    }

    @Override
    public void updateIngredients(String ingredients) {
        binding.setIngredients(ingredients);
    }

    @Override
    public void showLoading(int message) {
        pd = new ProgressDialog(getActivity());
        pd.setMessage(getString(message));
        pd.show();
    }

    @Override
    public void dismissLoading() {
        if (pd != null && pd.isShowing()) {
            pd.dismiss();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mOrderPresenter.start();
    }

    @Override
    public void onStart() {
        super.onStart();
        int width = getResources().getDimensionPixelSize(R.dimen.popup_width);
        getDialog().getWindow().setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onIngredientMinusViewClick(Ingredient i, TextView tv) {
        changeItemValue(i, tv, false);
    }

    @Override
    public void onIngredientPlusViewClick(Ingredient i, TextView tv) {
        changeItemValue(i, tv, true);
    }

    @Override
    public void onCancelListener() {
        dismissAllowingStateLoss();
    }

    @Override
    public void onFinishListener() {
        mOrderPresenter.finishOrder((MainActivity) getActivity());
        dismissAllowingStateLoss();
    }

    private void changeItemValue(Ingredient i, TextView tv, boolean plus) {
        int qt = mOrderPresenter.loadValueIngredient(i, Integer.parseInt(tv.getText().toString()), plus);
        tv.setText(String.valueOf(qt));
    }

    @BindingAdapter("addImageSandwich")
    public static void addImageSandwich(ImageView v, String image) {
        ImageLoader.getInstance().displayImage(image, v, ImageUtil.getSandwichImageOptions());

    }
}
