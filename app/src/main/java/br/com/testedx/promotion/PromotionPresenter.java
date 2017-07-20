package br.com.testedx.promotion;

import java.util.List;

import br.com.testedx.R;
import br.com.testedx.promotion.model.Promotion;
import br.com.testedx.java.util.retrofit.RetrofitManager;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by rafaela on 30/06/2017.
 */

class PromotionPresenter implements PromotionContract.Presenter {

    private PromotionContract.View mPromotionView;

    PromotionPresenter(PromotionContract.View mPromotionView) {
        this.mPromotionView = mPromotionView;
    }

    @Override
    public void start() {
        loadPromotions();
    }

    @Override
    public void loadPromotions() {
        mPromotionView.showLoading(R.string.search_promotions);
        Call<List<Promotion>> call = RetrofitManager.getInstance().getClient().getPromotions();
        call.enqueue(new Callback<List<Promotion>>() {

            @Override
            public void onResponse(Call<List<Promotion>> call, retrofit2.Response<List<Promotion>> response) {
                mPromotionView.dismissLoading();
                List<Promotion> p = response.body();
                if (p == null || p.isEmpty()) {
                    mPromotionView.showPromotionEmpityMessage();
                } else {
                    mPromotionView.loadSandwichs(p);
                }
            }

            @Override
            public void onFailure(Call<List<Promotion>> call, Throwable t) {
                mPromotionView.dismissLoading();
                mPromotionView.showPromotionEmpityMessage();
            }
        });
    }

}
