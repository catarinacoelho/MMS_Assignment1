package com.example.flickrgalleryapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

import java.util.List;

public class GridViewAdapter extends BaseAdapter {
    List<String> listSource;
    Context mainContext;

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
        final Button button;
        if(convertView == null)
        {
         button = new Button(mainContext);
         button.setLayoutParams(new GridView.LayoutParams(85,85));
         button.setPadding(8,8,8,8);
         button.setText(listSource.get(position));
         button.setOnClickListener(new View.OnClickListener (){
             @Override
             public void onClick(View v){

             }
         });
        }
        else
            button = (Button)convertView;
        return button;
    }
}
