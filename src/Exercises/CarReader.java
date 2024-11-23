package Exercises;

import Entities.Car;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CarReader {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();

        Car car1 = new Car("Red", "Ferrari", "19219324819", 2024);

        System.out.println(gson.toJson(car1));
    }
}
