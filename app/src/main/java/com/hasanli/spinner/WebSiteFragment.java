package com.hasanli.spinner;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple {@link Fragment} subclass.
 */
public class WebSiteFragment extends Fragment {

    WebView webv;
    public WebSiteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_website, container, false);

//        webv = (WebView) view.findViewById(R.id.webView);
//        webv.setWebViewClient(new WebViewClient());
//        webv.loadUrl("http://localhost:8080/spinners/");


        return view;


    }

}
