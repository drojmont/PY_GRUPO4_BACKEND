package com.backend.tourBooking.utils;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class JsonPrinter {
    public static String toString(Object t) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        String jsonString = gson.toJson(t).trim().replace("\n", "").replace("\t", "");

        return jsonString.replaceAll("\\s", "");

    }
}
