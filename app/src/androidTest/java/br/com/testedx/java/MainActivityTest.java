package br.com.testedx.java;

import android.content.Intent;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.squareup.okhttp.mockwebserver.Dispatcher;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;
import com.squareup.okhttp.mockwebserver.RecordedRequest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.testedx.R;
import br.com.testedx.main.MainActivity;
import br.com.testedx.java.util.Constants;
import br.com.testedx.java.util.RestServiceTestHelper;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by rafaela on 01/07/2017.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class,true, false);
    private MockWebServer mockWebServer = new MockWebServer();

    @Before
    public void setup() throws Exception {
        mockWebServer.start();
        Constants.URL_BASE = mockWebServer.getUrl("/").toString();
        mockWebServer.setDispatcher(dispatcher);

        Intent grouchyIntent = new Intent();
        // intent stuff
        grouchyIntent.putExtra("EXTRA_IS_GROUCHY", true);
        mActivityTestRule.launchActivity(grouchyIntent);
    }

    @Test
    public void clickNavigationButtonItem_showPromotionScreen() {
        onView(ViewMatchers.withId(R.id.navigation_promotion)).perform(click());
        onView(withId(R.id.recicle_promotion)).check(matches(isDisplayed()));
    }

    @Test
    public void clickNavigationButtonItem_showMenuScreen() {
        onView(withId(R.id.navigation_menu)).perform(click());
        onView(withId(R.id.recicle_menu)).check(matches(isDisplayed()));
    }

    @Test
    public void clickMenuItem_showShoppingCart() {
        onView(withId(R.id.cart)).perform(click());
        onView(withId(R.id.shopping_cart)).check(matches(isDisplayed()));
    }

    final Dispatcher dispatcher = new Dispatcher() {

        @Override
        public MockResponse dispatch(RecordedRequest request) throws InterruptedException {
            try {
                switch (request.getPath()) {
                    case "/api/ingrediente/":

                        return new MockResponse().setBody(RestServiceTestHelper.getStringFromFile(getInstrumentation().getContext(), "ingredients_200_ok_response.json")).setResponseCode(200);

                    case "/api/lanche/":
                        return new MockResponse().setBody(RestServiceTestHelper.getStringFromFile(getInstrumentation().getContext(), "sandwich_200_ok_response.json")).setResponseCode(200);

                    case "/v1/profile/info":
                        return new MockResponse().setResponseCode(200).setBody("{\\\"info\\\":{\\\"name\":\"Lucas Albuquerque\",\"age\":\"21\",\"gender\":\"male\"}}");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return new MockResponse().setResponseCode(404);
        }
    };
}
