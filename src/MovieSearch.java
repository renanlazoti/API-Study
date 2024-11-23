import Entities.Title;
import Entities.TitleOmdb;
import Exceptions.YearConvertionException;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieSearch {
    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner sc = new Scanner(System.in);
        String search = "";

        ArrayList<Title> titles = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!search.equalsIgnoreCase("exit")) {
            System.out.println("Type a film name: ");
            search = sc.nextLine();

            if (search.equalsIgnoreCase("exit")) {
                break;
            }

            try {

                String address = "https://www.omdbapi.com/?t=" + search.replace(" ", "+") + "&apikey=" + apikey;

                HttpClient client = HttpClient.newBuilder()
                        .version(HttpClient.Version.HTTP_1_1)
                        .connectTimeout(Duration.ofSeconds(20))
                        .build();

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(address))
                        .GET()
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                TitleOmdb titleOmdb = gson.fromJson(json, TitleOmdb.class);

                var mytitle = new Title(titleOmdb);
                System.out.println(titleOmdb);
                System.out.println("Converted title: " + mytitle);

                titles.add(mytitle);

                FileWriter writer = new FileWriter("archive.json");
                writer.write(gson.toJson(titles));
                writer.close();

            } catch (IllegalArgumentException e) {
                System.out.println("The application is failed, invalid argument: " + e.getMessage());
            } catch (YearConvertionException e) {
                System.out.println(e.getMessage());
            }

        }
        System.out.println("Finalized program!");
    }
}
