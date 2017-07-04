package br.com.testedx;


/**
 * Created by rafaela on 28/06/2017.
 */

@SuppressWarnings("ALL")
public interface BaseView<T extends BasePresenter> {

    void showLoading(int message);

    void dismissLoading();


}