package br.com.testedx.shoppingCart;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import java.util.HashMap;
import java.util.List;

import br.com.testedx.R;
import br.com.testedx.model.Ingredient;
import br.com.testedx.shoppingCart.model.Order;
import br.com.testedx.util.Constants;

/**
 * Created by rafaela on 28/06/2017.
 */
public class ShoppingCartActivity extends AppCompatActivity implements ShoppingCartContract.View {

    private ShoppingCartContract.Presenter presenter;
    private RecyclerView mRecyclerView;
    private ShoppingCartAdapter mAdapter;
    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        presenter = new ShoppingCartPeresenter(this, (HashMap<Integer, Ingredient>) getIntent().getExtras().getSerializable(Constants.INGREDIENTS));
        setupRecyclerView();
        presenter.start();
    }

    private void setupRecyclerView() {
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);
        mRecyclerView = (RecyclerView) findViewById(R.id.recicle_cart);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;

        }
        return false;
    }

    @Override
    public void showLoading(int message) {
        pd = new ProgressDialog(this);
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
    public void loadList(List<Order> sandwiches) {
        mAdapter = new ShoppingCartAdapter(sandwiches,presenter);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showEmpityMessage() {
        findViewById(R.id.txt_empity).setVisibility(View.VISIBLE);
    }

}
