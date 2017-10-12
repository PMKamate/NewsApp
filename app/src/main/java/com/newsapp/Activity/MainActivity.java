package com.newsapp.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.newsapp.Adapter.CategoryAdapter;
import com.newsapp.Entity.Category;
import com.newsapp.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list_category;
    CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findviewbyId();
        set_Category();
    }

    public void set_Category()
    {
        int[] ImgBckgrnd = {R.mipmap.ic_business,
                R.mipmap.ic_enter,
                R.mipmap.ic_game,
                R.mipmap.ic_general,
                R.mipmap.ic_music,
                R.mipmap.ic_poli,
                R.mipmap.ic_nature,
                R.mipmap.ic_sport,
                R.mipmap.ic_tech};

        // business, entertainment, gaming, general, music, politics, science-and-nature, sport, technology
        final ArrayList<Category> categories=new ArrayList<>();
        categories.add(new Category("business"));
        categories.add(new Category("entertainment"));
        categories.add(new Category("gaming"));
        categories.add(new Category("general"));
        categories.add(new Category("music"));
        categories.add(new Category("politics"));
        categories.add(new Category("science-and-nature"));
        categories.add(new Category("sport"));
        categories.add(new Category("technology"));


        categoryAdapter = new CategoryAdapter(MainActivity.this, categories,ImgBckgrnd);
        list_category.setAdapter(categoryAdapter);


        list_category.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3)
            {

                String categoryname_name=categories.get(position).getCategory_name();
                System.out.println("categoryname_name....."+categoryname_name);
                startActivity(new Intent(MainActivity.this, BBCNewsActivity.class).putExtra("categoryname", categoryname_name));
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);


            }
        });




    }

    public void findviewbyId()
    {
        list_category=(ListView)findViewById(R.id.list_category);
    }

}
