package com.example.flickrgalleryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        Intent intent = getIntent();
        final String url = intent.getStringExtra("url");
        String title = intent.getStringExtra("title");
        String tag = intent.getStringExtra("tag");
        String date = intent.getStringExtra("date");

        TextView titleTextView = (TextView) findViewById(R.id.title);
        titleTextView.setText("Title: " + title);

        TextView tagTextView = (TextView) findViewById(R.id.tag);
        tagTextView.setText("Tags: " + tag);

        TextView dateTextView = (TextView) findViewById(R.id.date);
        dateTextView.setText("Date: " + date);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        Picasso.with(ImageActivity.this)
                .load(url)
                .into(imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ImageActivity.this, FullSizeImageActivity.class);
                Intent fullScreen = intent.putExtra("fullScreen", url);
                startActivity(intent);
            }
        });

    }
}
