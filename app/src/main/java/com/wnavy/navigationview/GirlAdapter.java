package com.wnavy.navigationview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by netcore on 024 01/24.
 */

public class GirlAdapter extends RecyclerView.Adapter<GirlAdapter.ViewHolder> {
    private Context context;
    private List<Girl> girlList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView imageView;
        TextView textView;

        private ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            imageView = (ImageView) itemView.findViewById(R.id.girl_image);
            textView = (TextView) itemView.findViewById(R.id.girl_name);
        }
    }

    public GirlAdapter(List<Girl> girlList) {
        this.girlList = girlList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        if (this.context == null) {
            this.context = parent.getContext();
        }

        View view = LayoutInflater.from(this.context).inflate(R.layout.layout_girl, parent, false);

        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                Girl girl = girlList.get(position);
                Intent intent = new Intent(context, GirlActivity.class);
                intent.putExtra(GirlActivity.GIRL_NAME, girl.getName());
                intent.putExtra(GirlActivity.GIRL_IMAGE_ID, girl.getImageId());
                context.startActivity(intent);
            }
        });

        return viewHolder;
        //return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Girl girl = this.girlList.get(position);
        holder.textView.setText(girl.getName());
        //利用Glide加载图片到ImageView
        Glide.with(this.context).load(girl.getImageId()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return this.girlList.size();
    }
}
