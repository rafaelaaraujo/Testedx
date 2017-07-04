package br.com.testedx.promotion;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.testedx.R;
import br.com.testedx.promotion.model.Promotion;


/**
 * Created by rafaela on 28/06/2017.
 */
public class PromotionFragment extends Fragment implements PromotionContract.View {

    private View view;
    private RecyclerView mRecyclerView;
    private PromotionsAdapter mAdapter;
    private PromotionContract.Presenter presenter;
    private ProgressDialog pd;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_promotions_list, container, false);
        presenter = new PromotionPresenter(this);
        setupRecyclerView();

        return view;
    }

    private void setupRecyclerView() {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recicle_promotion);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
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
    public void loadSandwichs(List<Promotion> promotionList) {
        mAdapter = new PromotionsAdapter(promotionList);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showPromotionEmpityMessage() {
        view.findViewById(R.id.txt_promotion_empity).setVisibility(View.VISIBLE);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }
}
