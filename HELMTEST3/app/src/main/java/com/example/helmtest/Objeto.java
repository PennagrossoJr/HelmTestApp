package com.example.helmtest;

public class Objeto {

    private String mImageUrl;
    private String Id;
    private String mCreator;
    private String Status;
    private String Specie;
    private String Genero;
    private String Origen;
    private String Last_Location;

    public Objeto(String imageUrl, String id,String creator, String status, String specie, String genero, String origen, String last_location) {
        mImageUrl = imageUrl;
        mCreator = creator;
        Id = id;
        Status = status;
        Specie = specie;
        Genero = genero;
        Origen = origen;
        Last_Location = last_location;
    }

    public String getId() {
        return Id;
    }

    public String getmCreator() {
        return mCreator;
    }

    public String getStatus() {
        return Status;
    }

    public String getSpecie() {
        return Specie;
    }

    public String getGenero() {
        return Genero;
    }

    public String getOrigen() {
        return Origen;
    }

    public String getLast_Location() {
        return Last_Location;
    }

    public String getImageUrl() {
        return mImageUrl;
    }



}
