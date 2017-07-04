package br.com.testedx.menu;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.List;

import br.com.testedx.R;
import br.com.testedx.menu.listener.OnRecyclerViewClickListener;
import br.com.testedx.model.Ingredient;
import br.com.testedx.model.Sandwich;

public class MenuFragment extends Fragment implements MenuContract.View, OnRecyclerViewClickListener {

    private MenuContract.Presenter sandwichPresenter;
    private MenuAdapter mAdapter;
    private ProgressDialog pd;
    private RecyclerView mRecyclerView;

    private View rootView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView =  inflater.inflate(R.layout.sandwich_content, container, false);
        setupRecyclerView();
        sandwichPresenter = new MenuPresenter(this, (HashMap<Integer, Ingredient>) getArguments().getSerializable("ingredients"));
        sandwichPresenter.start();
        return rootView;
    }

    private void setupRecyclerView() {
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recicle_menu);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void showSandwichs(List<Sandwich> sandwichList, HashMap<Integer, Ingredient> ingredientsList) {
        mAdapter = new MenuAdapter(sandwichList, this);
        mRecyclerView.setAdapter(mAdapter);
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
    public void showAlertMessage(int message) {
        AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
        alertDialog.setMessage(getString(message));
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, getString(android.R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alertDialog.show();
    }

    @Override
    public void dismissAlertMessage() {
    }

    @Override
    public void finishCustomizerItem(Sandwich s) {
        sandwichPresenter.updateItem(s);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void addCart(Sandwich clickedObject) {
        sandwichPresenter.addItemToCart(clickedObject);
    }

    @Override
    public void editOrder(Sandwich clickedObject) {
        sandwichPresenter.openOrderDetail(getFragmentManager(), clickedObject);
    }

}
