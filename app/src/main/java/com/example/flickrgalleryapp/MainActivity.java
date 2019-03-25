package com.example.flickrgalleryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
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
        flickrService.getPhotos();
        GridView gridView = (GridView)findViewById(R.id.gridview);
        gridView.setAdapter(new GridViewAdapter(photos,this));

    }

    public void getItems() {
        List<Item> items = data.getItems();
        //items.add("https://farm8.staticflickr.com/7843/32524124047_5656894335_m.jpg");

        for(Item item:items){
            String url = item.getMedia().getM();
            photos.add(url);
        }
    }

    public void setFlickrData(FlickrData flickrData)
    {
        data = flickrData;
    }

}
