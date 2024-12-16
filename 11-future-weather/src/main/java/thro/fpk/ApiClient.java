package thro.fpk;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {

    public static String fetchWeatherData(String latitude, String longitude) throws Exception {
        String apiUrl = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude + "&longitude="+longitude+"&current_weather=true";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new java.net.URI(apiUrl))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}