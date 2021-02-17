package com.example.webviewpoc;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @POST("oauth2/access_token")
    Call<Void> getAuth(@HeaderMap Map<String, String> header,
                                                @Query("username") String userName,
                                                @Query("Pass") String password);

    @POST("shop/v21_2/sessions")
    Call<Void> session(@HeaderMap Map<String, String> header);
}
