package com.newsapp.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.newsapp.R;
import com.newsapp.View.HideKeybord;


public class WebDetailsActivity extends AppCompatActivity {
    WebView webView;
   // ProgressDialog pDialog;
    TextView tv_toolbar_title;
    String name,web_url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        findviewbyId();
        click();

    }
    public void findviewbyId() {
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tv_toolbar_title=(TextView)findViewById(R.id.tv_toolbar_title);
        Intent intent=getIntent();
        name=intent.getStringExtra("categoryname");
        web_url=intent.getStringExtra("web_url");
        tv_toolbar_title.setText(name.trim());

        webView= (WebView) findViewById(R.id.webview_view);
        webView.setWebViewClient(new MyWebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(web_url); // load the url on the web view

        LayoutInflater inflater = getLayoutInflater();
        getWindow().addContentView(inflater.inflate(R.layout.activity_test, null),
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.FILL_PARENT,
                        ViewGroup.LayoutParams.FILL_PARENT));
    }
    public void click()
    {


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                HideKeybord.hideKeyboard(WebDetailsActivity.this);
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
                onBackPressed();
                return true;



        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        HideKeybord.hideKeyboard(WebDetailsActivity.this);
        overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
    }


    // custom web view client class who extends WebViewClient
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
          // pDialog.dismiss();// load the url
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
           // pDialog.dismiss();
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);

           // pDialog = new ProgressDialog(WebDetailsActivity.this);
           // pDialog.setMessage("Please wait...");
           // pDialog.setCancelable(true);
           // pDialog.show();
        }
    }

}
