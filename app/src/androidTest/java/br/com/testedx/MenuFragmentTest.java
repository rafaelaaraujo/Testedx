package br.com.testedx;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.testedx.main.MainActivity;
import br.com.testedx.util.RecyclerViewMatcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static br.com.testedx.util.RecyclerViewMatcher.nthChildOf;

/**
 * Created by rafaela on 01/07/2017.
 */
@SuppressWarnings("ALL")
@RunWith(AndroidJUnit4.class)
public class MenuFragmentTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkScrooll_scrollAtPosition(){
        onView(withId(R.id.recicle_menu)).perform(scrollToPosition(3));
        onView(withId(R.id.recicle_menu)).perform(actionOnItemAtPosition(3, click()));
    }

    @Test
    public void clickEditButton_openEditDialogFragment(){
        onView(withId(R.id.recicle_menu)).perform(
                RecyclerViewActions.actionOnItemAtPosition(0, RecyclerViewMatcher.clickChildViewWithId(R.id. btn_customize)));

        onView(withId(R.id.picture_edit)).check(matches(isDisplayed()));
    }

    @Test
    public void clickAdd_AddItemInCart(){
        onView(withId(R.id.recicle_menu)).perform(
                RecyclerViewActions.actionOnItemAtPosition(0, RecyclerViewMatcher.clickChildViewWithId(R.id. btn_add_cart)));

        onView(withText("OK")).perform(click());
        onView(withText(R.id.notif_count)).check(matches(isDisplayed()));
    }

    @Test
    public void checkItemList(){
        onView(nthChildOf(withId(R.id.recicle_menu), 0)).check(matches(hasDescendant(withText("X-Bacon"))));
        onView(nthChildOf(withId(R.id.recicle_menu), 0)).check(matches(hasDescendant(withText("R$7,50"))));
    }
}
