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
        int position = intent.getExtras().getInt("position");

        ImageView imageView = findViewById(R.id.imageView);
        Picasso.with(ImageActivity.this)
                .load(MainActivity.photos.get(position))
                .into(imageView);

    }
}
