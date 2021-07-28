package com.example.webnews.ui.NDTV;

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

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        WebView webView = (WebView)root.findViewById(R.id.ndtvweb);
        webView.loadUrl("https://www.ndtv.com/");

        //we want to see all news on our app so we creat a class name :WebViewController

        webView.setWebViewClient(new WebViewController());




        return root;
    }
}