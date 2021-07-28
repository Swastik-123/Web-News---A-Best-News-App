package com.example.webnews.ui.BBC;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.webnews.MainActivity;
import com.example.webnews.R;
import com.example.webnews.WebViewController;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);





        WebView webView  = (WebView)root.findViewById(R.id.bbcweb);
        webView.loadUrl("https://www.bbc.com/");
        //we want to see all news on our app so we creat a class name :WebViewController
        webView.setWebViewClient(new WebViewController());







        return root;
    }
}