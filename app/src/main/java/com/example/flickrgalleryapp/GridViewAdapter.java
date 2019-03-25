package com.example.flickrgalleryapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class GridViewAdapter extends BaseAdapter {
    private List<String> listSource;
    private Context mainContext;

    public GridViewAdapter(List<String> listSource, Context mainContext) {
        this.listSource = listSource;
        this.mainContext = mainContext;
    }

    @Override
    public int getCount() {
        return listSource.size();
    }

    @Override
    public Object getItem(int position) {
        return listSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView img;
        if(convertView == null){
            img = new ImageView(mainContext);
            convertView = img;
            img.setPadding(5,5,5,5);
        }
        else{
            img = (ImageView) convertView;
        }
        String url = listSource.get(position);
        Picasso.with(mainContext)
                .load(url)
                .into(img);

        return convertView;
        /*ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mainContext);
            imageView.setLayoutParams(new GridView.LayoutParams(480, 480));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        String url = listSource.get(position);
        Picasso.with(mainContext)
                .load(url)
                .into(imageView);
        return imageView;
        //Initialize ImageView
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        //Loading image from below URL into imageView
        Picasso.with(mainContext)
                .load("YOUR IMAGE URL HERE")
                .into(imageView);*/
    }
}
