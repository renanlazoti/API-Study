package Exercises;

import Exceptions.GitHubConsultException;

import java.util.Scanner;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiGitHub {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        System.out.println("Type a username of github: ");
        String username = sc.nextLine();

        String endereco = "https://api.github.com/users/" + username;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .header("Accept", "application/vnd.github.v3+json")
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 404) {
                throw new GitHubConsultException("User not find in GitHub");
            }

            String json = response.body();
            System.out.println(json);
        } catch (IOException | InterruptedException e) {
            System.out.println("There was a error durante during a GitHub API consult");
            e.printStackTrace();
        } catch (GitHubConsultException e) {
            System.out.println(e.getMessage());
        }
    }
}
