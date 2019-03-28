package com.example.flickrgalleryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class FullSizeImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_size_image);

        Intent intent = getIntent();
        String fullPhoto = intent.getStringExtra("fullScreen");

        ImageView fullImageView = (ImageView) findViewById(R.id.fullImageView);
        Picasso.with(FullSizeImageActivity.this)
                .load(fullPhoto)
                .into(fullImageView);
    }
}
