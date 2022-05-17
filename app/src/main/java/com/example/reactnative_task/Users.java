package com.example.reactnative_task;

public class Users {

    String Catname , CatBreed, CatDes ;

    public Users() {
    }

    public Users(String catname, String catBreed, String catDes) {
        Catname = catname;
        CatBreed = catBreed;
        CatDes = catDes;
    }

    public String getCatname() {
        return Catname;
    }

    public void setCatname(String catname) {
        Catname = catname;
    }

    public String getCatBreed() {
        return CatBreed;
    }

    public void setCatBreed(String catBreed) {
        CatBreed = catBreed;
    }

    public String getCatDes() {
        return CatDes;
    }

    public void setCatDes(String catDes) {
        CatDes = catDes;
    }
}

