package br.com.testedx.util.retrofit;

import org.json.JSONObject;

import java.util.List;
import java.util.Map;

import br.com.testedx.model.Ingredient;
import br.com.testedx.model.Sandwich;
import br.com.testedx.promotion.model.Promotion;
import br.com.testedx.shoppingCart.model.Order;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ServiceInterface {

    @GET("api/ingrediente/")
    Call<List<Ingredient>> getIngredients();

    @GET("api/promocao/")
    Call<List<Promotion>> getPromotions();

    @GET("api/pedido/")
    Call<List<Order>> getCartItens();

    @GET("api/lanche/")
    Call<List<Sandwich>> getSandwichs();

    @PUT("api/pedido/{id}")
    Call<JSONObject> addItemToCart(@Path("id") String id, @Body Map<String, String> jsonObject);

    @GET("api/lanche/{id}")
    Call<Sandwich> getItem(@Path("id") String id);
}