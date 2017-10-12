package com.newsapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.newsapp.Entity.Category;
import com.newsapp.R;

import java.util.ArrayList;

public class CategoryAdapter extends BaseAdapter {

    ArrayList<Category> categories;
    Context context;

    private int[] ImgBckgrnd;
    public CategoryAdapter(Context context, ArrayList<Category> categories,int[] ImgBckgrnd) {
        this.context=context;
        this.categories=categories;
        this.ImgBckgrnd=ImgBckgrnd;
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Object getItem(int position) {
        return categories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        Settxt_categoryHolder holder = null;
        if (convertView == null) {
            LayoutInflater li = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = li.inflate(R.layout.adapter_set_category, null);
            holder = new Settxt_categoryHolder(row);
            row.setTag(holder);
        } else {
            holder = (Settxt_categoryHolder) row.getTag();
        }

        Category categories1=categories.get(position);
        holder.txt_category.setText(categories1.getCategory_name());
        holder.icon.setBackgroundResource(getImage(position));
        return row;
    }

    class Settxt_categoryHolder
    {
        TextView txt_category;
        ImageView icon;
        public Settxt_categoryHolder(View base) {
            icon = (ImageView) base.findViewById(R.id.img_icon);
            txt_category = (TextView)base.findViewById(R.id.txt_category);
        }
    }
    public int getImage(int groupPosition){
        return ImgBckgrnd[groupPosition];
    }
}
