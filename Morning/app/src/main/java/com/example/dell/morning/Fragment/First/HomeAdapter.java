package com.example.dell.morning.Fragment.First;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.morning.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2018/1/25.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyviewHolder>{
    private Context context;
    private ArrayList<String> list;

    public HomeAdapter(Context context, ArrayList list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyviewHolder(LayoutInflater.from(context).inflate(R.layout.item_first,parent,false));
    }

    @Override
    public void onBindViewHolder(MyviewHolder holder, int position) {
//        holder.imageView.setImageBitmap(null);imageView
        holder.text.setText(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView text;
        String tital;//左上角标签
        public MyviewHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imagine);
            text=itemView.findViewById(R.id.text);
        }
    }
}
