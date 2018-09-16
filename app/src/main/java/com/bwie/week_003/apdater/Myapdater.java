package com.bwie.week_003.apdater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bwie.week_003.R;
import com.bwie.week_003.bean.UIbean;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Myapdater extends RecyclerView.Adapter<MyViewHolder> {
    List<UIbean.Pois> list;
    Context context;

    public Myapdater(List<UIbean.Pois> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        MyViewHolder inflate = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item,parent,false));

        return inflate;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_text.setText(list.get(position).getName());
        Log.i("sasa", "onBindViewHolder: "+list.get(position).getName());
        List<UIbean.Pois.Photo> photos = list.get(position).getPhotos();
       /* String url = list.get(position).getPhotos().get(0).getUrl();
        Picasso.with(context).load(url).into(holder.tv_image);*/

        if (photos != null && photos.size() > 0) {
            Glide.with(context)
                    .load(photos.get(0).getUrl())
                    .into(holder.tv_image);
        }


        /* if(list.get(position).getPhotos().size()<=0){
        }else {

             Glide.with(context).load(list.get(position).getPhotos().get(0).getUrl().toString()).into(holder.tv_image);
         }*/




    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }
}
