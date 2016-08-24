package com.example.gabriela.retrofitexample;

/**
 * Created by Gabriela on 8/24/2016.
 */
// This is used to map the JSON keys to the object by GSON
public class Question {

    String title;
    String link;

    @Override
    public String toString() {
        return(title);
    }
}
