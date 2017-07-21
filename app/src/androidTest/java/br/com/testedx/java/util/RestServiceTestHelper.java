package br.com.testedx.java.util;

import android.content.Context;
import android.util.Log;

import com.squareup.okhttp.mockwebserver.Dispatcher;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.RecordedRequest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import static android.support.test.InstrumentationRegistry.getInstrumentation;


public class RestServiceTestHelper {

    public static String convertStreamToString(InputStream is) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        reader.close();
        return sb.toString();
    }

    public static String getStringFromFile(Context context, String filePath) throws Exception {
        final InputStream stream = context.getResources().getAssets().open(filePath);

        String ret = convertStreamToString(stream);
        //Make sure you close all streams.
        stream.close();
        return ret;
    }

    public final static Dispatcher dispatcher = new Dispatcher() {

        @Override
        public MockResponse dispatch(RecordedRequest request) throws InterruptedException {
            try {
                Log.e("DISPACHER-----",request.getPath()+"//"+request.getRequestLine());
                switch (request.getPath()) {
                    case "/api/ingrediente/":
                        return new MockResponse().setResponseCode(200).setBody(RestServiceTestHelper.getStringFromFile(getInstrumentation().getContext(), "ingredients_200_ok_response.json"));
                    case "/api/lanche/1":
                        return new MockResponse().setResponseCode(200).setBody(RestServiceTestHelper.getStringFromFile(getInstrumentation().getContext(), "item_200_ok_response.json"));
                    case "/api/pedido/":
                        return new MockResponse().setResponseCode(200).setBody(RestServiceTestHelper.getStringFromFile(getInstrumentation().getContext(), "cart_200_ok_response.json"));
                    case "/api/lanche/":
                        return new MockResponse().setResponseCode(200).setBody(RestServiceTestHelper.getStringFromFile(getInstrumentation().getContext(), "sandwich_200_ok_response.json"));
                    case "/api/promocao/":
                        return new MockResponse().setResponseCode(200).setBody(RestServiceTestHelper.getStringFromFile(getInstrumentation().getContext(), "promotion_200_ok_response.json"));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return new MockResponse().setResponseCode(404);
        }
    };
}
