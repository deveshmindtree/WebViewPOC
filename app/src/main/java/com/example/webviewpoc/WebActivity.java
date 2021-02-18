package com.example.webviewpoc;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import okhttp3.Cookie;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.webviewpoc.databinding.ActivityWebBinding;

public class WebActivity extends AppCompatActivity {

    private String postUrl = "https://zzkf-003.sandbox.us01.dx.commercecloud.salesforce.com/s/RefArch/home?lang=en_US";

    private ActivityWebBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWebBinding.inflate(getLayoutInflater());

      /*  String cookieString = "cookie_name=cookie_value; path=/";
        CookieManager.getInstance().setCookie(postUrl, cookieString);*/

        /*CookieSyncManager cookieSyncManager = CookieSyncManager.createInstance(binding.webView.getContext());
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.removeSessionCookie();
        cookieManager.setCookie("http://xx.example.com","mid="+MySession.GetSession().sessionId+" ; Domain=.example.com");
        cookieSyncManager.sync();*/

        String myUrl = "https://zzkf-003.sandbox.us01.dx.commercecloud.salesforce.com/";
        CookieSyncManager.createInstance(this);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.removeSessionCookie();
        String cookieString = "oc_sfcc" + "=" + WebviewPocApp.authToken + "; domain=" + myUrl;
        Log.d("Auth:", WebviewPocApp.authToken);
        cookieManager.setCookie(myUrl, cookieString);
        CookieSyncManager.getInstance().sync();


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