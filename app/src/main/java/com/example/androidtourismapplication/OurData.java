package com.example.androidtourismapplication;

public class OurData {

    private String Name;
    private int Photo;

    public OurData() {

    }

    public OurData(String name, int photo) {
        Name = name;
        Photo = photo;
    }

    public String getName() {
        return Name;
    }

    public int getPhoto() {
        return Photo;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }


}
