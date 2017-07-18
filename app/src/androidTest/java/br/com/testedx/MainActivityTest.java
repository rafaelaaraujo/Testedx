package br.com.testedx;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;

import org.eclipse.jetty.http.HttpStatus;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.testedx.main.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

/**
 * Created by rafaela on 01/07/2017.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8080);
    WireMockServer wireMockServer;

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void exampleTest() {
        WireMock.configureFor("localhost", BuildConfig.PORT);

        stubFor(get(urlEqualTo("/api/ingrediente/"))
                .willReturn(aResponse()
                        .withStatus(HttpStatus.OK_200)
                        .withHeader("Content-Type", "text/xml")
                        .withBody("[{\"id\":1,\"name\":\"Alface\",\"price\":0.4,\"image\":\"https://goo.gl/9DhCgk\"},{\"id\":2,\"name\":\"Bacon\",\"price\":2,\"image\":\"https://goo.gl/8qkVH0\"},{\"id\":3,\"name\":\"Hamburguer de Carne\",\"price\":3,\"image\":\"https://goo.gl/U01SnT\"},{\"id\":4,\"name\":\"Ovo\",\"price\":0.8,\"image\":\"https://goo.gl/weL1Rj\"},{\"id\":5,\"name\":\"Queijo\",\"price\":1.5,\"image\":\"https://goo.gl/D69Ow2\"},{\"id\":6,\"name\":\"Pão com gergelim\",\"price\":1,\"image\":\"https://goo.gl/evgjyj\"}]")));


        stubFor(get(urlEqualTo("/api/lanche/"))
                .willReturn(aResponse()
                        .withStatus(HttpStatus.OK_200)
                        .withHeader("Content-Type", "text/xml")
                        .withBody("[{\"id\":1,\"name\":\"X-Bacon\",\"ingredients\":[2,3,5,6],\"image\":\"https://goo.gl/W9WdaF\"},{\"id\":2,\"name\":\"X-Burger\",\"ingredients\":[3,5,6],\"image\":\"https://goo.gl/Cjfxi9\"},{\"id\":3,\"name\":\"X-Egg\",\"ingredients\":[3,4,5,6],\"image\":\"https://goo.gl/x4rNIq\"},{\"id\":4,\"name\":\"X-Egg Bacon\",\"ingredients\":[1,2,3,4,5,6],\"image\":\"https://goo.gl/2L0lqg\"}]")));

    }

    @Test
    public void clickNavigationButtonItem_showPromotionScreen(){
        onView(withId(R.id.navigation_promotion)).perform(click());
        onView(withId(R.id.recicle_promotion)).check(matches(isDisplayed()));
    }

    @Test
    public void clickNavigationButtonItem_showMenuScreen(){
        onView(withId(R.id.navigation_menu)).perform(click());
        onView(withId(R.id.recicle_menu)).check(matches(isDisplayed()));
    }

    @Test
    public void clickMenuItem_showShoppingCart(){
        onView(withId(R.id.cart)).perform(click());
        onView(withId(R.id.shopping_cart)).check(matches(isDisplayed()));
    }
}
