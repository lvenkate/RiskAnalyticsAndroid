package com.cmpe277.investor;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.webkit.WebView;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
public class InvestorDetailActivity extends AppCompatActivity {

  public static final String TAG = InvestorDetailActivity.class.getSimpleName();

  private WebView mWebView;
  String title;
  String url;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_investor_detail);

    // Get recipe data passed from previous activity
    title = this.getIntent().getExtras().getString("companyId");
    url = this.getIntent().getExtras().getString("url");

    // Set title on action bar of this activity
    setTitle(title);

    // Create WebView and load web page
    mWebView = (WebView) findViewById(R.id.detail_web_view);
    mWebView.getSettings().setLoadWithOverviewMode(true);
    mWebView.getSettings().setUseWideViewPort(true);
    mWebView.setInitialScale(1);
    mWebView.getSettings().setJavaScriptEnabled(true);
    mWebView.getSettings().setLoadWithOverviewMode(true);
    mWebView.getSettings().setUseWideViewPort(true);
    mWebView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
    mWebView.setScrollbarFadingEnabled(false);
    mWebView.loadUrl(url);

  }



}


