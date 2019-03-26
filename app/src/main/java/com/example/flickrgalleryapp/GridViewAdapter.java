package com.example.flickrgalleryapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
    }
}
