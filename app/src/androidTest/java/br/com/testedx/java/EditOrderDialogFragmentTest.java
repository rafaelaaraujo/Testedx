package br.com.testedx.java;

import android.content.Intent;
import android.os.SystemClock;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.squareup.okhttp.mockwebserver.MockWebServer;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.testedx.R;
import br.com.testedx.java.util.Constants;
import br.com.testedx.java.util.RestServiceTestHelper;
import br.com.testedx.main.MainActivity;
import br.com.testedx.java.util.RecyclerViewMatcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static br.com.testedx.java.util.RecyclerViewMatcher.nthChildOf;

/**
 * Created by rafaela on 01/07/2017.
 */
@RunWith(AndroidJUnit4.class)
public class EditOrderDialogFragmentTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class,true, false);
    private MockWebServer mockWebServer = new MockWebServer();

    @Before
    public void setup() throws Exception {
        mockWebServer.start();
        Constants.URL_BASE = mockWebServer.getUrl("/").toString();
        mockWebServer.setDispatcher(RestServiceTestHelper.dispatcher);

        Intent grouchyIntent = new Intent();
        // intent stuff
        grouchyIntent.putExtra("EXTRA_IS_GROUCHY", true);
        mActivityTestRule.launchActivity(grouchyIntent);
        SystemClock.sleep(1000);

        onView(ViewMatchers.withId(R.id.recicle_menu)).perform(
                RecyclerViewActions.actionOnItemAtPosition(0, RecyclerViewMatcher.clickChildViewWithId(R.id.btn_customize)));
    }

    @Test
    public void checkPrice() {
        onView(withId(R.id.txt_price_edit_order)).check(matches(withText("Total do pedido: R$7,50")));
    }

    @Test
    public void clickPlusEgg_addMoreAndUpdatePrice() {
        actionClickItemRecicler(0,R.id.btn_plus);
        onView(nthChildOf(withId(R.id.recicle_edit_order), 0)).check(matches(hasDescendant(withText("1"))));
        onView(withId(R.id.txt_price_edit_order)).check(matches(withText("Total do pedido: R$8,30")));
    }

    private void actionClickItemRecicler(int positionItem, int itemId) {
        onView(withId(R.id.recicle_edit_order)).perform(
                RecyclerViewActions.actionOnItemAtPosition(positionItem, RecyclerViewMatcher.clickChildViewWithId(itemId)));
    }

    @Test
    public void clickMinusHamburguer_decreasesAndUpdatePrice() {
        actionClickItemRecicler(5,R.id.btn_minus);
        onView(nthChildOf(withId(R.id.recicle_edit_order), 5)).check(matches(hasDescendant(withText("0"))));
        onView(withId(R.id.txt_price_edit_order)).check(matches(withText("Total do pedido: R$4,50")));
    }

    @Test
    public void checkTextPromotionLight() {
        actionClickItemRecicler(1,R.id.btn_plus);
        actionClickItemRecicler(5,R.id.btn_minus);

        onView(nthChildOf(withId(R.id.recicle_edit_order), 5)).check(matches(hasDescendant(withText("0"))));
        onView(withId(R.id.txt_price_edit_order)).check(matches(withText("Total do pedido: R$4,90")));
        onView(withId(R.id.txt_price_discounts)).check(matches(isDisplayed()));
        onView(withId(R.id.txt_price_discounts)).check(matches(withText("Total com desconto LIGHT: R$4,41")));
    }

    @Test
    public void checkTextPromotionMeat() {
        actionClickItemRecicler(5,R.id.btn_plus);
        actionClickItemRecicler(5,R.id.btn_plus);

        onView(nthChildOf(withId(R.id.recicle_edit_order), 5)).check(matches(hasDescendant(withText("3"))));
        onView(withId(R.id.txt_price_edit_order)).check(matches(withText("Total do pedido: R$13,50")));
        onView(withId(R.id.txt_price_discounts)).check(matches(withText("Total com desconto CARNE: R$10,50")));
    }

    @Test
    public void checkTextPromotionCheese() {
        actionClickItemRecicler(3,R.id.btn_plus);
        actionClickItemRecicler(3,R.id.btn_plus);

        onView(nthChildOf(withId(R.id.recicle_edit_order), 3)).check(matches(hasDescendant(withText("3"))));
        onView(withId(R.id.txt_price_edit_order)).check(matches(withText("Total do pedido: R$10,50")));
        onView(withId(R.id.txt_price_discounts)).check(matches(isDisplayed()));
        onView(withId(R.id.txt_price_discounts)).check(matches(withText("Total com desconto QUEIJO: R$9,00")));
    }
}
