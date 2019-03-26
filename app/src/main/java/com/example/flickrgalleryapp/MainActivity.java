package com.example.flickrgalleryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
    static List<String> photos = new ArrayList<String>();
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flickrService = new FlickrServiceImplementation(this);
        flickrService.getPhotos();

        gridView = (GridView)findViewById(R.id.gridview);
        gridView.setAdapter(new GridViewAdapter(photos,this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(MainActivity.this,ImageActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);

            }
        });

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
