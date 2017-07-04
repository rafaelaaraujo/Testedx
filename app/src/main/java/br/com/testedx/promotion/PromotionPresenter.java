package br.com.testedx.promotion;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.List;

import br.com.testedx.R;
import br.com.testedx.promotion.model.Promotion;
import br.com.testedx.util.Constants;
import br.com.testedx.util.volley.VolleyHelper;

/**
 * Created by rafaela on 30/06/2017.
 */

@SuppressWarnings("ALL")
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
        String url = Constants.URL_BASE + "/promocao/";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, sucessLoadIPromotion, errorLoadPromotion);
        VolleyHelper.getInstance().addToRequestQueue(request);
    }


    private Response.Listener<JSONArray> sucessLoadIPromotion = new Response.Listener<JSONArray>() {

        @Override
        public void onResponse(JSONArray response) {
            mPromotionView.dismissLoading();
            Type listType = new TypeToken<List<Promotion>>() {}.getType();
            List<Promotion> p = new Gson().fromJson(response.toString(), listType);
            if(p.isEmpty()){
                mPromotionView.showPromotionEmpityMessage();
            }else {
                mPromotionView.loadSandwichs(p);
            }
        }
    };

    private Response.ErrorListener errorLoadPromotion = new Response.ErrorListener() {

        @Override
        public void onErrorResponse(VolleyError error) {
            mPromotionView.dismissLoading();
            mPromotionView.showPromotionEmpityMessage();
        }
    };
}
