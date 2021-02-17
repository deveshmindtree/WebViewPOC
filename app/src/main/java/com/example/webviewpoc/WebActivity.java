package com.example.webviewpoc;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.webviewpoc.databinding.ActivityWebBinding;

public class WebActivity extends AppCompatActivity {

    private String postUrl = "https://zzkf-003.sandbox.us01.dx.commercecloud.salesforce.com/on/demandware.store/Sites-dixons-Site/default/Home-Show";

    private ActivityWebBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWebBinding.inflate(getLayoutInflater());

        MyWebViewClient webViewClient = new MyWebViewClient();
        binding.webView.setWebViewClient(webViewClient);
        binding.webView.getSettings().setJavaScriptEnabled(true);
        binding.webView.getSettings().setBuiltInZoomControls(true);
        binding.webView.loadUrl(postUrl);
        binding.webView.setHorizontalScrollBarEnabled(false);

        setContentView(binding.getRoot());
    }

    private class MyWebViewClient extends WebViewClient {
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(String.valueOf(request.getUrl()));
            return true;
        }
    }
}