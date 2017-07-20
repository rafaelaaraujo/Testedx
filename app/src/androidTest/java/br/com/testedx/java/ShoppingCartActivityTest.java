package br.com.testedx.java;

import android.os.SystemClock;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.testedx.R;
import br.com.testedx.main.MainActivity;
import br.com.testedx.java.util.RecyclerViewMatcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static br.com.testedx.java.util.RecyclerViewMatcher.nthChildOf;

/**
 * Created by rafaela on 01/07/2017.
 */

@RunWith(AndroidJUnit4.class)
public class ShoppingCartActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void addItemInCart_openActivity() {
        onView(ViewMatchers.withId(R.id.recicle_menu)).perform(
                RecyclerViewActions.actionOnItemAtPosition(1, RecyclerViewMatcher.clickChildViewWithId(R.id.btn_add_cart)));
        SystemClock.sleep(1000);
        onView(withText("OK")).perform(click());
        onView(withId(R.id.cart)).perform(click());
    }

    @Test
    public void checkItemTotal() {
        onView(nthChildOf(withId(R.id.recicle_cart), 0)).check(matches(hasDescendant(withText("X-Burger"))));
        onView(nthChildOf(withId(R.id.recicle_cart), 0)).check(matches(hasDescendant(withText("Subtotal: R$5,50"))));
    }
}
