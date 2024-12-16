package thro.fpk;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.concurrent.*;

public class WeatherService {

    private final ExecutorService executorService = Executors.newFixedThreadPool(3);

    public Future<Integer> fetchTemperature(String latitude, String longitude) {
       return executorService.submit(new Callable<Integer>() {
           @Override
           public Integer call() throws Exception {
               String weatherdata = ApiClient.fetchWeatherData(latitude, longitude);
               ObjectMapper objectMapper = new ObjectMapper();
               JsonNode rootNode = objectMapper.readTree(weatherdata);
               return rootNode.at("/current_weather/temperature").asInt();
           }
       });
    }

    public CompletableFuture<Integer> fetchTemperatureAsync(String latitude, String longitude) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                String jsonResponse = ApiClient.fetchWeatherData(latitude, longitude);
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode rootNode = objectMapper.readTree(jsonResponse);
                return rootNode.at("/current_weather/temperature").asInt();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }


    public CompletableFuture<Double> fetchAvgTemp() {
        String[][] locations = {
                {"47.8567", "12.1225"},
                {"48.3903", "-4.4860"},
                {"59.9139", "10.7461"}
        };

        CompletableFuture<Integer> temp1 = fetchTemperatureAsync(locations[0][0], locations[0][1]);
        CompletableFuture<Integer> temp2 = fetchTemperatureAsync(locations[1][0], locations[1][1]);
        CompletableFuture<Integer> temp3 = fetchTemperatureAsync(locations[2][0], locations[2][1]);

        return CompletableFuture.allOf(temp1, temp2, temp3)
                .thenApply(v -> {
                    try {
                        int temperature1 = temp1.get();
                        int temperature2 = temp2.get();
                        int temperature3 = temp3.get();
                        return (temperature1 + temperature2 + temperature3) / 3.0;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }

                });
    }

    public CompletableFuture<String> fetchWeatherDescriptionAsync(String latitude, String longitude) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                String jsonResponse = ApiClient.fetchWeatherData(latitude, longitude);
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode rootNode = objectMapper.readTree(jsonResponse);
                int weatherCode = rootNode.at("/current_weather/weathercode").asInt();
                return WmoCodes.getDescription(weatherCode);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    public CompletableFuture<String> fetchWeatherSummary(String latitude, String longitude) {
        CompletableFuture<Integer> temperatureFuture = fetchTemperatureAsync(latitude, longitude);
        CompletableFuture<String> descriptionFuture = fetchWeatherDescriptionAsync(latitude, longitude);

        return temperatureFuture.thenCombine(descriptionFuture, (temperature, description) ->
                "Temperature: " + temperature + "°C, Weather: " + description
        );
    }

    public static void main(String[] args) throws Exception {
        WeatherService weatherService = new WeatherService();
        String[][] locations = {
                {"47.8567", "12.1225"},
                {"48.3903", "-4.4860"},
                {"59.9139", "10.7461"}
        };


        Future<Integer> temp1 = weatherService.fetchTemperature(locations[0][0], locations[0][1]);
        Future<Integer> temp2 = weatherService.fetchTemperature(locations[1][0], locations[1][1]);
        Future<Integer> temp3 = weatherService.fetchTemperature(locations[2][0], locations[2][1]);

        int temperature1 = temp1.get();
        int temperature2 = temp2.get();
        int temperature3 = temp3.get();

        double averageTemperature = (temperature1 + temperature2 + temperature3) / 3.0;
        System.out.println("Average Temperature: " + averageTemperature + "°C");

        weatherService.fetchAvgTemp().thenAccept(averageTemperatureCompletableFuture -> {
            System.out.println("Average Temperature: " + averageTemperatureCompletableFuture + "°C");
        }).join();



        for (String[] location : locations) {
            weatherService.fetchWeatherSummary(location[0], location[1]).thenAccept(summary -> {
                System.out.println("Location (" + location[0] + ", " + location[1] + "): " + summary);
            }).join();
        }


    }
}
