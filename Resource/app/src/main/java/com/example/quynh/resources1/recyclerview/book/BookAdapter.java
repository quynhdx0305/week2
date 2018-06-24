package com.example.quynh.resources1.recyclerview.book;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.quynh.resources1.R;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    ArrayList<BookListOverView> bookname;
    Context context;
    //String imgUrlbase = "http://api.nytimes.com/svc/books/v3/lists\n";

    //contractor
    public BookAdapter(ArrayList<BookListOverView> bookname, Context context) {
        this.bookname = bookname;
        this.context = context;
    }
    //tao clas ViewHolder anh xa tu ben book_name.xml
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtlist_name;
        TextView txtdisplay_name;
        TextView txtlist_name_encoded;
        TextView txtoldest_published_date;
        TextView txtnewest_published_date;
        TextView txtupdated;

        public ViewHolder(View itemView) {
            super(itemView);
            txtlist_name = (TextView)itemView.findViewById(R.id.txt1);
            txtdisplay_name = (TextView)itemView.findViewById(R.id.txt2);
            txtlist_name_encoded = (TextView)itemView.findViewById(R.id.txt3);
            txtoldest_published_date = (TextView)itemView.findViewById(R.id.txt4);
            txtnewest_published_date = (TextView)itemView.findViewById(R.id.txt5);
            txtupdated = (TextView)itemView.findViewById(R.id.txt6);
        }
    }

    @NonNull
    @Override
    public BookAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.book_name,parent,false);
        return new ViewHolder(itemView);// goi class ViewHolder
    }

    @Override
    public void onBindViewHolder(@NonNull BookAdapter.ViewHolder holder, int position) {
        holder.txtlist_name.setText(bookname.get(position).getList_name());//lay list name
        holder.txtdisplay_name.setText(bookname.get(position).getDisplay_name());
        holder.txtlist_name_encoded.setText(bookname.get(position).getList_name_encoded());
        //holder.txtoldest_published_date.setText(bookname.get(position).getOldest_published_date());
        //holder.txtnewest_published_date.setText(bookname.get(position).getNewest_published_date());
        holder.txtupdated.setText(bookname.get(position).getUpdated());
    }

    @Override
    public int getItemCount() { return bookname.size();
    }
}
