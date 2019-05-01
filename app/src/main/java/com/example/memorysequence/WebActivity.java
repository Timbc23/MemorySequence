package com.example.memorysequence;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.squareup.picasso.Picasso;


public class WebActivity extends AppCompatActivity {

    /**
     * Displays a specified web page.
     */
    private WebView webpage;
    private String url =  "https://www.wikihow.com/Play-Simon-Says";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_picture);

        webpage =  (WebView)findViewById(R.id.webView);
        webpage.setWebViewClient(new WebViewClient());
        webpage.getSettings().setJavaScriptEnabled(true);
        webpage.getSettings().setDomStorageEnabled(true);
        webpage.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
        webpage.loadUrl(url);
    }
}
