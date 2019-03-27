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
                //Create intent
                Intent intent = new Intent(MainActivity.this, ImageActivity.class);
                intent.putExtra("url", item);

                //Start details activity
                startActivity(intent);

                /*Intent intent = new Intent(MainActivity.this,ImageActivity.class);
                intent.putExtra("photo", photos.get(position));
                startActivity(intent);*/

            }
        });

    }

    public void getItems() {
        List<Item> items = data.getItems();

        for(Item item:items){
            String url = item.getMedia().getM();
            photos.add(url);
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
