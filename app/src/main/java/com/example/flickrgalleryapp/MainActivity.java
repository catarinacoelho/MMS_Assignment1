package com.example.flickrgalleryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;


import java.util.ArrayList;
import java.util.List;

import rest.FlickrData;
import rest.FlickrServiceImplementation;
import rest.Item;

public class MainActivity extends AppCompatActivity {
    FlickrServiceImplementation flickrService;
    FlickrData data;
    static List<String> photos = new ArrayList<String>();
    static List<String> titles = new ArrayList<String>();
    static List<String> tags = new ArrayList<String>();
    static List<String> dates = new ArrayList<String>();
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flickrService = new FlickrServiceImplementation(this);
        flickrService.getPhotos();

        gridView = (GridView) findViewById(R.id.gridview);
        GridViewAdapter gridAdapter = new GridViewAdapter(photos,this);
        gridView.setAdapter(gridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                String item = photos.get(position);
                String title = titles.get(position);
                String tag = tags.get(position);
                String date = dates.get(position);
                //Create intent
                Intent intent = new Intent(MainActivity.this, ImageActivity.class);
                intent.putExtra("url", item);
                intent.putExtra("title", title);
                intent.putExtra("tag", tag);
                intent.putExtra("date", date);

                //Start details activity
                startActivity(intent);

            }
        });

    }

    public void getItems() {
        List<Item> items = data.getItems();

        for(Item item:items){
            String url = item.getMedia().getM();
            photos.add(url);
            titles.add(item.getTitle());
            tags.add(item.getTags());
            dates.add(item.getDateTaken());
        }
        gridView = (GridView) findViewById(R.id.gridview);
        GridViewAdapter gridAdapter = new GridViewAdapter(photos,this);
        gridView.setAdapter(gridAdapter);


    }

    public void setFlickrData(FlickrData flickrData)
    {
        data = flickrData;
    }

}
