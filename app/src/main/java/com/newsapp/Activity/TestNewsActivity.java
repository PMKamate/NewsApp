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


public class TestNewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {

            case android.R.id.home:
                HideKeybord.hideKeyboard(TestNewsActivity.this);
                overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
                onBackPressed();
                return true;


        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        HideKeybord.hideKeyboard(TestNewsActivity.this);
        overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
    }


}
