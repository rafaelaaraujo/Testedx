package br.com.testedx.util.volley;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import br.com.testedx.Testedx;

/**
 * Created by rafaela on 28/06/2017.
 */

@SuppressWarnings("ALL")
public class VolleyHelper {

    private static VolleyHelper mInstance;
    private RequestQueue mRequestQueue;

    private VolleyHelper() {
        mRequestQueue = getRequestQueue();
    }

    public static synchronized VolleyHelper getInstance() {
        if (mInstance == null) {
            mInstance = new VolleyHelper();
        }
        return mInstance;
    }

    private RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(Testedx.getContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }


}
