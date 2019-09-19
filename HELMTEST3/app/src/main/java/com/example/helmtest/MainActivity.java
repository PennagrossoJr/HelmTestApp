package com.example.helmtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;


public class MainActivity extends AppCompatActivity implements Adaptador.OnItemClickListener {
    public static final String EXTRA_URL = "imageUrl";
    public static final String EXTRA_CREATOR = "creatorName";
    public static final String EXTRA_ID = "imageid";
    public static final String EXTRA_STATUS = "Status";
    public static final String EXTRA_SPECIES = "Specie";
    public static final String EXTRA_GENDER = "Gender";
    public static final String EXTRA_ORIGIN = "Origen";
    public static final String EXTRA_LOCATION = "Location";

    //public static final String EXTRA_LIKES = "likeCount";

    private RecyclerView mRecyclerView;
    private Adaptador mExampleAdapter;
    private ArrayList<Objeto> mExampleList;
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mExampleList = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);
        parseJSON();
    }

    private void parseJSON() {
        String url = "https://rickandmortyapi.com/api/character/";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("results");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject hit = jsonArray.getJSONObject(i);

                                String creatorName = hit.getString("name");

                                creatorName = "NAME: " + creatorName;

                                String imageUrl = hit.getString("image");
                                String id = hit.getString("id");

                                id = "ID: " + id;

                                //System.out.println(id + "  Leyendo de la API");

                                String Status = hit.getString("status");

                                Status = "STATUS: " + Status;

                                //System.out.println(Status + "  Leyendo de la API");

                                String Specie = hit.getString("species");

                                Specie = "SPECIES: " + Specie;

                                //System.out.println(Specie + "  Leyendo de la API");

                                String Genero = hit.getString("gender");

                                Genero = "GENDER: " + Genero;

                                //System.out.println(Genero + "  Leyendo de la API");

                                //JSONArray OrigenList = (JSONArray) hit.get("origin");

                                String Origen = hit.getJSONObject("origin").getString("name");  //  getString("origin");

                                Origen = "ORIGIN: " + Origen;

                                //JSONArray visit = (JSONArray) hit.get("origin");

                                //String Origen = visit.get(0).toString();

                               // String Origen = iterator.next();

                                //System.out.println(Origen + "  Leyendo de la API");

                                String Last_Location = hit.getJSONObject("location").getString("name");

                                Last_Location = "LAST LOCATION: " + Last_Location;

                                //System.out.println(Last_Location + "  Leyendo de la API");


                                //int likeCount = hit.getInt("likes");
                                mExampleList.add(new Objeto(imageUrl,id,creatorName,Status,Specie,Genero,Origen,Last_Location));
                            }

                            mExampleAdapter = new Adaptador(MainActivity.this, mExampleList);
                            mRecyclerView.setAdapter(mExampleAdapter);
                            mExampleAdapter.setOnItemClickListener(MainActivity.this);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mRequestQueue.add(request);
    }

    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(this, Actividad_en_detalle.class);
        Objeto clickedItem = mExampleList.get(position);

        detailIntent.putExtra(EXTRA_URL, clickedItem.getImageUrl());
        detailIntent.putExtra(EXTRA_ID, clickedItem.getId());
        detailIntent.putExtra(EXTRA_CREATOR, clickedItem.getmCreator());
        detailIntent.putExtra(EXTRA_STATUS, clickedItem.getStatus());
        detailIntent.putExtra(EXTRA_SPECIES, clickedItem.getSpecie());
        detailIntent.putExtra(EXTRA_GENDER, clickedItem.getGenero());
        detailIntent.putExtra(EXTRA_ORIGIN, clickedItem.getOrigen());
        detailIntent.putExtra(EXTRA_LOCATION, clickedItem.getLast_Location());


        //detailIntent.putExtra(EXTRA_LIKES, clickedItem.getLikeCount());
        startActivity(detailIntent);
    }
}
