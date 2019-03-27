package com.example.flickrgalleryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        Picasso.with(ImageActivity.this)
                .load(url)
                .into(imageView);
/*
        Intent intent = getIntent();
        int photo = intent.getExtras().getInt("photo");

        ImageView imageView = findViewById(R.id.imageView);

*/
    }
}
