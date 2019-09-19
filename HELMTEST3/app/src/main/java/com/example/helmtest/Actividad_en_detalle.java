package com.example.helmtest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static com.example.helmtest.MainActivity.EXTRA_CREATOR;
import static com.example.helmtest.MainActivity.EXTRA_GENDER;
import static com.example.helmtest.MainActivity.EXTRA_ID;
import static com.example.helmtest.MainActivity.EXTRA_LOCATION;
import static com.example.helmtest.MainActivity.EXTRA_ORIGIN;
import static com.example.helmtest.MainActivity.EXTRA_SPECIES;
import static com.example.helmtest.MainActivity.EXTRA_STATUS;
import static com.example.helmtest.MainActivity.EXTRA_URL;


public class Actividad_en_detalle extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_en_detalle);

        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra(EXTRA_URL);
        String creatorName = intent.getStringExtra(EXTRA_CREATOR);
        String Id = intent.getStringExtra(EXTRA_ID);
        String Status = intent.getStringExtra(EXTRA_STATUS);
        String Specie = intent.getStringExtra(EXTRA_SPECIES);
        String Genero = intent.getStringExtra(EXTRA_GENDER);
        String Origen = intent.getStringExtra(EXTRA_ORIGIN);
        String Last_Location = intent.getStringExtra(EXTRA_LOCATION);


        //int likeCount = intent.getIntExtra(EXTRA_LIKES, 0);

        ImageView imageView = findViewById(R.id.image_view_detalle);
        TextView textViewCreator = findViewById(R.id.name_character);
        TextView textViewID = findViewById(R.id.id);
        TextView textViewStatus = findViewById(R.id.status);
        TextView textViewSpecie = findViewById(R.id.specie);
        TextView textViewGenero = findViewById(R.id.gender);
        TextView textViewOrigen = findViewById(R.id.origin);
        TextView textViewLocation = findViewById(R.id.last_location);


        //TextView textViewLikes = findViewById(R.id.text_view_like_detail);

        Picasso.with(this).load(imageUrl).fit().centerInside().into(imageView);
        textViewCreator.setText(creatorName);
        textViewID.setText(Id);
        textViewStatus.setText(Status);
        textViewSpecie.setText(Specie);
        textViewGenero.setText(Genero);
        textViewOrigen.setText(Origen);
        textViewLocation.setText(Last_Location);
        //textViewLikes.setText("Likes: " + likeCount);
    }
}

