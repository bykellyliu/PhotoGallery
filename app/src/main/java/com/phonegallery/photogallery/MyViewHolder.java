package com.phonegallery.photogallery;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by kellyliu on 2017-06-10.
 */

public class MyViewHolder implements View.OnClickListener {
    ImageView img;
    TextView nameTxt;
    RatingBar rating;
    ItemClickListener itemClickListener;

    public MyViewHolder(View v) {
        img = (ImageView) v.findViewById(R.id.imageView1);
        nameTxt = (TextView) v.findViewById(R.id.nameTv);
        rating = (RatingBar) v.findViewById(R.id.rate);
        v.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(v);


    }

    public void setItemClickListener(ItemClickListener ic) {
        this.itemClickListener = ic;

    }
}
