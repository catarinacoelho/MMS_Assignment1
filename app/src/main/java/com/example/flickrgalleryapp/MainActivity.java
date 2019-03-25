package com.example.flickrgalleryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import rest.FlickrData;
import rest.FlickrServiceImplementation;
import rest.Item;

public class MainActivity extends AppCompatActivity {
    FlickrServiceImplementation flickrService;
    FlickrData data;
    List<String> photos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flickrService = new FlickrServiceImplementation(this);
        List<Item> items = data.getItems();

        for(Item item:items){
            String url = item.getMedia().getM();
            photos.add(url);
        }

        GridView gridView = (GridView)findViewById(R.id.gridView);
        gridView.setAdapter(new GridViewAdapter(photos,this));
    }

    public void setFlickrData(FlickrData flickrData)
    {
        data = flickrData;
    }

}
