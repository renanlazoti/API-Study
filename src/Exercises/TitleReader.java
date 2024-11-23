package Exercises;

import Entities.Title;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;

public class TitleReader {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();

        Title title = new Title("Madmax", 1979);

        System.out.println(gson.toJson(title));
    }
}
