package com.example.webviewpoc;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.webviewpoc.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        getAuthToken();
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, WebActivity.class));
            }
        });
        setContentView(binding.getRoot());
    }

    public void getAuthToken() {
        ApiInterface authService = RetrofitAuthClient.createServiceBasicAuth(ApiInterface.class);
        Call<AuthModel> callAsync = authService.getAuth("client_credentials");
        callAsync.enqueue(new Callback<AuthModel>() {
            @Override
            public void onResponse(Call<AuthModel> call, Response<AuthModel> response) {
                AuthModel user = response.body();
                WebviewPocApp.authToken = user.getAccess_token();
            }

            @Override
            public void onFailure(Call<AuthModel> call, Throwable throwable) {
                System.out.println(throwable);
            }
        });
    }

}