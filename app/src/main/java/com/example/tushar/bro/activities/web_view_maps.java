package com.example.tushar.bro.activities;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.tushar.bro.R;
import com.example.tushar.bro.entities.RushEvent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.GoogleMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class web_view_maps extends BaseActivity {

    private GoogleMap map;
    private GoogleApiClient api;
    private RushEvent event;

    @BindView(R.id.map_name)
    TextView name;
    @BindView(R.id.mapdate)
    TextView date;
    @BindView(R.id.map_location)
    TextView location;
    @BindView(R.id.map_description)
    TextView descrition;
@BindView(R.id.activity_maps)
    WebView webView;
    @BindView(R.id.activity_webview_progress)
    ProgressBar progressBar;
    private static final String RUSH_MAP_INFO="RUSH_MAP_INFO";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_pdf);
        ButterKnife.bind(this);
        progressBar.setMax(100);
        event=getIntent().getParcelableExtra(RUSH_MAP_INFO);
        name.setText(event.getEventName());
        date.setText(event.getEventDate());
        location.setText(event.getEventDate());
        descrition.setText(event.getEventDescription());
        String googledocs="https://docs.google.com/gview?url=";
        String embedded="&embedded=true";
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);

        webView.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);

                if(newProgress==100){
                    progressBar.setVisibility(View.GONE);
                }else
                {
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setProgress(newProgress);
                }
            }
        });

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });
        webView.loadUrl(googledocs+"http://www.asu.edu/map/pdf/asu_map_tempe_2015.pdf"+embedded);
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }
        super.onBackPressed();
    }

    public static Intent newIntent(Context context,RushEvent event){

        Intent intent=new Intent(context,web_view_maps.class);
        intent.putExtra(RUSH_MAP_INFO,event);
        return intent;
    }
}
