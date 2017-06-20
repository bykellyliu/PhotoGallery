package com.phonegallery.photogallery;

/**
 * Created by kellyliu on 2017-05-27.
 */

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.phonegallery.photogallery.model.Photo;

import java.util.ArrayList;

public class Adapter extends BaseAdapter implements Filterable {

    Context c;
    ArrayList<Photo> photos;
    CustomFilter filter;
    ArrayList<Photo> filterList;

    public Adapter(Context ctx, ArrayList<Photo> photos) {
        // TODO Auto-generated constructor stub

        this.c = ctx;
        this.photos = photos;
        this.filterList = photos;
    }

    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.nameTxt.setText(photos.get(position).getName());
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return photos.size();
    }

    @Override
    public Object getItem(int pos) {
        // TODO Auto-generated method stub
        return photos.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        // TODO Auto-generated method stub
        return photos.indexOf(getItem(pos));
    }

    @Override
    public View getView(final int pos, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.model, null);
        }

        TextView nameTxt = (TextView) convertView.findViewById(R.id.nameTv);
        ImageView img = (ImageView) convertView.findViewById(R.id.imageView1);
        RatingBar rating=(RatingBar) convertView.findViewById(R.id.rate);


        //SET DATA TO THEM
        final MyViewHolder holder = new MyViewHolder(convertView);
        holder.nameTxt.setText(photos.get(pos).getName());
        holder.img.setImageResource(photos.get(pos).getImg());
        holder.rating.setRating(photos.get(pos).getRating());


        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v) {
                //Toast.makeText(c, cities.get(pos).getName(), Toast.LENGTH_SHORT).show();
                String c = photos.get(pos).getName();
                switch (c) {
                    case "Hong Kong":

                        v.getContext().startActivity(new Intent(v.getContext(), HongKong.class));
                        break;

                    case "Taipei":
                        v.getContext().startActivity(new Intent(v.getContext(), Taipei.class));
                        break;

                    case "Tokyo":
                        v.getContext().startActivity(new Intent(v.getContext(), Tokyo.class));
                        break;

                    case "Seoul":
                        v.getContext().startActivity(new Intent(v.getContext(), Seoul.class));
                        break;

                }

            }


        });
        return convertView;
    }

    @Override
    public Filter getFilter() {
        // TODO Auto-generated method stub
        if (filter == null) {
            filter = new CustomFilter();
        }

        return filter;
    }

    //INNER CLASS
    class CustomFilter extends Filter {

        @Override       protected FilterResults performFiltering(CharSequence constraint) {
            // TODO Auto-generated method stub

            FilterResults results = new FilterResults();
            if (constraint != null && constraint.length() > 0) {
                //CONSTARINT TO UPPER
                constraint = constraint.toString().toUpperCase();

                ArrayList<Photo> filters = new ArrayList<Photo>();

                //get specific items
                for (int i = 0; i < filterList.size(); i++) {
                    if (filterList.get(i).getName().toUpperCase().contains(constraint)) {
                        Photo p = new Photo(filterList.get(i).getName(), filterList.get(i).getImg(), filterList.get(i).getRating());
                        filters.add(p);
                    }
                }

                results.count = filters.size();
                results.values = filters;

            } else {
                results.count = filterList.size();
                results.values = filterList;

            }

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            // TODO Auto-generated method stub

            photos = (ArrayList<Photo>) results.values;
            notifyDataSetChanged();
        }

    }

}