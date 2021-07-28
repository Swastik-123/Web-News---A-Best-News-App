package com.example.webnews;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewController extends WebViewClient {

    //just write should and you can get full meathod
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {

        view.loadUrl(url);
        return true;
    }
}
