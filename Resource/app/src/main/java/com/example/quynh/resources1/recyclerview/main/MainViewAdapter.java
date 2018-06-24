package com.example.quynh.resources1.recyclerview.main;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.quynh.resources1.R;
import com.example.quynh.resources1.calendar.CustomTab;

import java.util.ArrayList;

public class MainViewAdapter extends RecyclerView.Adapter<MainViewAdapter.ViewHolder> {
    ArrayList<MainView> mainViews;
    Context context;
    String imgUrlbase = "http://www.nytimes.com/";

    public MainViewAdapter(ArrayList<MainView> mainViews, Context context) {
        this.mainViews = mainViews;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.main,parent,false);
        return new ViewHolder(itemView);// goi class ViewHolder ben duoi
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //holder.web_url.setText(mainViews.get(position).getWeb_url());
        holder.snippet.setText(mainViews.get(position).getSnippet());
        //holder.url_hinh.setText(mainViews.get(position).getUrl_hinh());
        Log.d("BindViewHolder Position", String.valueOf((position)));
        Glide.with(context).load(imgUrlbase + mainViews.get(position).getUrl_hinh()).into(holder.hinh);
    }

    @Override
    public int getItemCount() {
       return mainViews.size();
    }

    //tao clas ViewHolder anh xa tu ben main.xml
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView web_url;
        TextView snippet;
        TextView url_hinh;
        ImageView hinh;


        public ViewHolder(View itemView) {
            super(itemView);
            //web_url = (TextView)itemView.findViewById(R.id.txtmain1);
            snippet = (TextView)itemView.findViewById(R.id.txtmain2);
            //url_hinh = (TextView)itemView.findViewById(R.id.txtmain3);
            hinh = (ImageView)itemView.findViewById(R.id.imgmain1);

            itemView.setOnClickListener(this);
        }

        //fun Click position Item
        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            Log.d("position", String.valueOf((position)));
            Toast.makeText(context, "Click :" + String.valueOf((position)), Toast.LENGTH_LONG).show();

            Intent intent = new Intent(context,CustomTab.class);
            intent.putExtra("url_web",mainViews.get(position).getWeb_url());
            context.startActivity(intent);
        }
    }

}
