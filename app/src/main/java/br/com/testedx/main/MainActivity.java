package br.com.testedx.main;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.HashMap;

import br.com.testedx.R;
import br.com.testedx.menu.MenuFragment;
import br.com.testedx.model.Ingredient;
import br.com.testedx.model.Sandwich;
import br.com.testedx.promotion.PromotionFragment;
import br.com.testedx.shoppingCart.ShoppingCartActivity;
import br.com.testedx.java.util.Constants;

public class MainActivity extends AppCompatActivity implements MainContract.View, BottomNavigationView.OnNavigationItemSelectedListener {

    private ProgressDialog pd;
    private MenuFragment menuFragment;
    private MainContract.Presenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenter(this);
        mainPresenter.start();
    }

    @Override
    public void initBottomNavigation() {
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        Menu menu = navigation.getMenu();
        selectFragment(menu.getItem(0));
        navigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public void showAlertMessage(int s) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setMessage(getString(s));
        alertDialog.setCancelable(false);
        alertDialog.show();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        selectFragment(item);
        return true;
    }

    private void selectFragment(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.navigation_menu:
                mainPresenter.openFragmentMenu();
                break;
            case R.id.navigation_promotion:
                changeFragment(new PromotionFragment(), null);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.cart)
            mainPresenter.openShoppingCard();
        return super.onOptionsItemSelected(item);
    }

    private void changeFragment(Fragment fragment, Bundle b) {
        if (b != null)
            fragment.setArguments(b);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void finishEditOrder(Sandwich s) {
        menuFragment.finishCustomizerItem(s);
    }

    public void updateItemMenu(Sandwich s) {
        menuFragment.updateMenuItem(s);
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
    public void openShoppingCard(HashMap<Integer, Ingredient> ingredientHashMap) {
        Intent i = new Intent(this, ShoppingCartActivity.class);
        i.putExtras(getBundleIngredients(ingredientHashMap));
        startActivity(i);
    }

    @NonNull
    private Bundle getBundleIngredients(HashMap<Integer, Ingredient> ingredientHashMap) {
        Bundle b = new Bundle();
        b.putSerializable(Constants.INGREDIENTS, ingredientHashMap);
        return b;
    }

    @Override
    public void showFragmentMenu(HashMap<Integer, Ingredient> ingredientHashMap) {
        menuFragment = new MenuFragment();
        changeFragment(menuFragment, getBundleIngredients(ingredientHashMap));
    }
}
