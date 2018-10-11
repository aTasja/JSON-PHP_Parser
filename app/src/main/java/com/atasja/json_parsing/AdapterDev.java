package com.atasja.json_parsing;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.Collections;
import java.util.List;

public class AdapterDev extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private LayoutInflater inflater;
    List<DataDev> data= Collections.emptyList();
    DataDev current;
    int currentPos=0;

    // create constructor to innitilize context and data sent from MainActivity
    public AdapterDev(Context context, List<DataDev> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.container_dev, parent,false);
        MyHolder holder=new MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in recyclerview to bind data and assign values from list
        MyHolder myHolder= (MyHolder) holder;
        DataDev current=data.get(position);
        myHolder.textName.setText(current.name);
        myHolder.textName.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));
        myHolder.textTitle.setText("Title: " + current.title);

        // load image into imageview using glide
        Glide.with(context).load(current.image)
                .into(myHolder.ivDev);

    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{

        TextView textName;
        TextView textTitle;
        ImageView ivDev;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            textName= (TextView) itemView.findViewById(R.id.textName);
            textTitle = (TextView) itemView.findViewById(R.id.textTitle);
            ivDev= (ImageView) itemView.findViewById(R.id.ivDev);
        }

    }

}
