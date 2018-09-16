package com.bwie.week_003.apdater;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.week_003.R;

class MyViewHolder extends RecyclerView.ViewHolder {

    public TextView tv_text;
    public ImageView tv_image;

    public MyViewHolder(View itemView) {
        super(itemView);
        tv_image = itemView.findViewById(R.id.tv_image);
        tv_text = itemView.findViewById(R.id.tv_text);
    }
}
