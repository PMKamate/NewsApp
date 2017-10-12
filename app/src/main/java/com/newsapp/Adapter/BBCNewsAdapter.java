package com.newsapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.newsapp.BBC_Sources.Source;
import com.newsapp.Interface.OnItemClickListener;
import com.newsapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by Asus3 on 11/05/2016.
 */
public class BBCNewsAdapter extends RecyclerView.Adapter<BBCNewsAdapter.MyViewHolder> {

    List<Source> hypnotherapy;
    Context context;
    OnItemClickListener onItemClickListener;
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txt_title,txt_desc;
        ImageView img_profile_pic;

        public MyViewHolder(View convertView) {
            super(convertView);

            txt_title = (TextView) convertView.findViewById(R.id.txt_title);
            txt_desc = (TextView) convertView.findViewById(R.id.txt_desc);
           /* txt_price = (TextView) convertView.findViewById(R.id.txt_price);
            txt_name = (TextView) convertView.findViewById(R.id.txt_name);
            img_profile_pic=(ImageView) convertView.findViewById(R.id.img_profile_pic);*/

            convertView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            if (onItemClickListener != null) onItemClickListener.onClick(v, getAdapterPosition());

        }
    }

    public BBCNewsAdapter(Context context, List<Source> meditations) {
        this.context=context;
        this.hypnotherapy = meditations;
    }
    public void setClickListener(OnItemClickListener itemClickListener) {
        this.onItemClickListener = itemClickListener;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_bbcnews, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Source course = hypnotherapy.get(position);
        holder.txt_title.setText(course.getName());
        holder.txt_desc.setText(course.getDescription());

       /* if(course.getPictureUrl()!=null&&course.getPictureUrl().length()>0&&!course.getPictureUrl().equals(""))
        {
           // Picasso.with(context).load(course.getPictureUrl()).into(holder.img_profile_pic);
            Picasso.with(context).load(course.getPictureUrl()).resize(100,100).into(holder.img_profile_pic);

        }
        else {
          holder.img_profile_pic.setImageResource(R.drawable.profile);
        }*/

    }

    @Override
    public int getItemCount() {
        return hypnotherapy.size();
    }

}
