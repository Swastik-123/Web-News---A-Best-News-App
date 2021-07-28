package com.example.webnews.ui.ABP;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.webnews.R;
import com.example.webnews.WebViewController;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        WebView webView = (WebView)root.findViewById(R.id.abpWeb);
        webView.loadUrl("https://bengali.abplive.com/");

        //we want to see all news on our app so we creat a class name :WebViewController

        webView.setWebViewClient(new WebViewController());




        return root;
    }
}