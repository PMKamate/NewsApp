package com.newsapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.newsapp.Adapter.BBCNewsAdapter;
import com.newsapp.BBC_Sources.BBCSources;
import com.newsapp.BBC_Sources.Source;
import com.newsapp.Interface.OnItemClickListener;
import com.newsapp.InternetConnection.InternetConnection;
import com.newsapp.R;
import com.newsapp.RestClient.ApiUtils;
import com.newsapp.View.HideKeybord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BBCNewsActivity extends AppCompatActivity implements OnItemClickListener {

    BBCNewsAdapter bbcNewsAdapter;
    List<Source> sources;
    private RecyclerView recyclerView;
    LinearLayout ll_progress;
    ProgressBar progressBar;
    TextView tv_toolbar_title;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbcnews);

        findviewbyId();
        progressBar.setVisibility(View.VISIBLE);
        if (InternetConnection.isNetworkAvailable(BBCNewsActivity.this)) {
            call_categorydata();
        }
        else {
            Toast.makeText(BBCNewsActivity.this, getResources().getString(R.string.something_went_wrong),Toast.LENGTH_SHORT).show();

        }


    }

    public void findviewbyId()
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tv_toolbar_title=(TextView)findViewById(R.id.tv_toolbar_title);
        Intent intent=getIntent();
        name=intent.getStringExtra("categoryname");
        tv_toolbar_title.setText(name.trim());
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        ll_progress=(LinearLayout) findViewById(R.id.ll_progress);
        progressBar= (ProgressBar) findViewById(R.id.progressBar);

    }
    public void call_categorydata()
    {
        HashMap<String, String> params = new HashMap<String, String>();

        params.put("language","en");
        params.put("id", "bbc-news");
        params.put("category",name);


        Call<BBCSources> call = ApiUtils.getAPIService().BBCSources("en","bbc-news",name);

        call.enqueue(new Callback<BBCSources>() {
            @Override
            public void onResponse(Call<BBCSources> call, Response<BBCSources> response) {
                System.out.println("m_practitioner_id: responce" );
                sources=new ArrayList<>();
                progressBar.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
                if (response.isSuccessful()) {
                    if (response.body().status.equals("ok")) {
                        sources=response.body().sources;

                        Log.w("tag_coursedata", new Gson().toJson(sources));
                        recyclerView.setVisibility(View.VISIBLE);
                        bbcNewsAdapter = new BBCNewsAdapter(BBCNewsActivity.this,sources);
                        LinearLayoutManager layoutManager = new LinearLayoutManager(BBCNewsActivity.this);
                        recyclerView.setLayoutManager(layoutManager);

                        recyclerView.setAdapter(bbcNewsAdapter);
                        bbcNewsAdapter.setClickListener(BBCNewsActivity.this);
                    }
                }

            }

            @Override
            public void onFailure(Call<BBCSources> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
               Toast.makeText(BBCNewsActivity.this, getResources().getString(R.string.something_went_wrong),Toast.LENGTH_SHORT).show();
            }


        });



    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {

            case android.R.id.home:
                HideKeybord.hideKeyboard(BBCNewsActivity.this);
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
                onBackPressed();
                return true;


        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        HideKeybord.hideKeyboard(BBCNewsActivity.this);
        overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
    }

    @Override
    public void onClick(View view, final int position) {

        if (InternetConnection.isNetworkAvailable(BBCNewsActivity.this)) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(sources.size()>0) {
                        String web_url = sources.get(position).getUrl();
                        startActivity(new Intent(BBCNewsActivity.this, WebDetailsActivity.class).putExtra("web_url", web_url).putExtra("categoryname",name));
                        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                    }
                }
            }, 270);
        }
        else {
           Toast.makeText(BBCNewsActivity.this, getResources().getString(R.string.internet_connection),Toast.LENGTH_SHORT).show();

        }
    }
}
