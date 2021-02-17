package com.example.webviewpoc;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.view.View;

import com.example.webviewpoc.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String BEARER = "Bearer";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String CONTENT_TYPE_VALUE = "application/json";
    private ApiInterface service = RetrofitApiClient.createService(ApiInterface.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        setContentView(binding.getRoot());
    }

    public void getAuthToken() {
        Call<AuthModel> callAsync = service.getAuth("");

        callAsync.enqueue(new Callback<AuthModel>() {
            @Override
            public void onResponse(Call<AuthModel> call, Response<AuthModel> response) {
                AuthModel user = response.body();
            }

            @Override
            public void onFailure(Call<AuthModel> call, Throwable throwable) {
                System.out.println(throwable);
            }
        });
    }

    public void loadSession() {
        Call<Void> callAsync = service.session();

        callAsync.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
            }

            @Override
            public void onFailure(Call<Void> call, Throwable throwable) {
                System.out.println(throwable);
            }
        });
    }

}