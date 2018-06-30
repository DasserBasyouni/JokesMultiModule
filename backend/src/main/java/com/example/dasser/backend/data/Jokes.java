package com.example.dasser.backend.data;

public class Jokes {

    private static String[] jokes = {
            "What kind of music are balloons afraid of?\nPop Music"
    };

    public static String getJoke() {
        return jokes[0];
    }
}
