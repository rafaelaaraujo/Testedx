package br.com.testedx.promotion;

import java.util.List;

import br.com.testedx.BasePresenter;
import br.com.testedx.BaseView;
import br.com.testedx.promotion.model.Promotion;

/**
 * Created by rafaela on 30/06/2017.
 */

class PromotionContract {

    interface View extends BaseView<PromotionContract.Presenter> {

        void loadSandwichs(List<Promotion> promotionList);

        void showPromotionEmpityMessage();
    }

    interface Presenter extends BasePresenter {

        void loadPromotions();

    }
}
