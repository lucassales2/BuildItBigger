package com.example;

import java.util.Random;

public class JokeTeller {

    private static final String[] jokes = {
            "The truth is out there. Anybody got the URL?",
            "There are only 10 types of people in the world: those that understand binary and those that don’t.",
            "Computers make very fast, very accurate mistakes.",
            "CAPS LOCK – Preventing Login Since 1980",
            "If at first you don’t succeed; call it version 1.0.",
            "My attitude isn’t bad. It’s in beta.",
            "Hey! It compiles! Ship it!"
    };

    public static String getJoke() {
        return jokes[new Random().nextInt(jokes.length-1)];
    }

}
