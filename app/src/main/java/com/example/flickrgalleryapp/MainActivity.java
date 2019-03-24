package com.example.flickrgalleryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import rest.FlickrData;
import rest.FlickrServiceImplementation;

public class MainActivity extends AppCompatActivity {
    FlickrServiceImplementation flickrService;
    FlickrData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flickrService = new FlickrServiceImplementation(this);
    }

    public void setFlickrData(FlickrData flickrData){
        data = flickrData;
    }

}
