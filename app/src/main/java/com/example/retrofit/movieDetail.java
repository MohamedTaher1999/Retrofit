package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class movieDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        Intent intent = getIntent();
        movieModel item = (movieModel) intent.getSerializableExtra("object");


        ImageView imageView = findViewById(R.id.img_pic);
        TextView textViewCreator = findViewById(R.id.tv_movieName);
        TextView textViewLikes = findViewById(R.id.tv_movieDiscribtion);
        ImageButton favour=findViewById(R.id.btn_favour);
        Picasso.with(this).load("https://image.tmdb.org/t/p/w500"+item.getPoster_path()).fit().centerInside().into(imageView);
        textViewCreator.setText(item.getOriginal_title());
        textViewLikes.setText(item.getOverview());


    }
}
