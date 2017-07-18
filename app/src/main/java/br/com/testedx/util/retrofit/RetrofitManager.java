package br.com.testedx.util.retrofit;

import br.com.testedx.util.Constants;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rafaela.araujo on 18/07/2017.
 */

public class RetrofitManager {

    private static RetrofitManager retrofitManager;

    private Retrofit retrofit;
    private ServiceInterface client;

    public static RetrofitManager getInstance(){
        if(retrofitManager == null){
            retrofitManager = new RetrofitManager();
        }

        return  retrofitManager;
    }

    private RetrofitManager(){
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(Constants.URL_BASE)
                .addConverterFactory(
                        GsonConverterFactory.create()
                );
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        retrofit = builder.client(httpClient.build()).build();
        client =  retrofit.create(ServiceInterface.class);
    }


    public ServiceInterface getClient() {
        return client;
    }
}
