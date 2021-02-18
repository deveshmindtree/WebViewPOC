package com.example.webviewpoc;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @POST("oauth2/access_token")
    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Call<AuthModel> getAuth(@Field("grant_type") String username);

    @POST("shop/v21_2/sessions")
    Call<Void> loadSession(@HeaderMap Map<String, String> header);
}
