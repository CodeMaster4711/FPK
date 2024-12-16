# 11 future and completablefuture

## Scenario:

You are tasked with creating a Weather Forecasting Service that fetches weather data asynchronously from the Open-Meteo API. The service needs to:

- Fetch the current temperature from three different locations using the Open-Meteo API.

- Combine the results from all locations to calculate the average temperature.

- Provide a mechanism to fetch weather data either synchronously or asynchronously.

## Requirements:

### Provided Code:

#### ApiClient
To simplify the assignment, we provide a utility Class ```ApiClient``` for fetching data from the Open-Meteo API. This ensures you can focus on implementing asynchronous programming.

```java
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

```

You will use this  to fetch weather data.

#### Using Jackson

For parsing the JSON response from the Open-Meteo API, we will use the Jackson library. Jackson is a popular Java library for processing JSON data. It provides features to parse JSON strings into Java objects and vice versa.

Gradle Dependency
Ensure that the following dependency is added to your ``build.gradle`` file:


``implementation 'com.fasterxml.jackson.core:jackson-databind:2.15.2'``


In the assignment, you will use the following Jackson classes:
```java
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
```

#### Key Concepts:
1. ObjectMapper:
  A central class in Jackson for converting JSON data to and from Java objects. We use it to read JSON strings and map them into a tree structure or Java objects.

2. JsonNode:
Represents a node in a JSON tree. It allows easy navigation and extraction of specific fields from a JSON response.

Example Code:

Here’s how Jackson is used to extract data from the API response:

```java
// Initialize ObjectMapper
ObjectMapper objectMapper = new ObjectMapper();

// Sample JSON string (replace with actual API response)
String jsonResponse = "{ \"current_weather\": { \"temperature\": 25, \"weathercode\": \"3\" }}";

// Parse JSON string into a JsonNode
JsonNode rootNode = objectMapper.readTree(jsonResponse);

// Access specific fields
int temperature = rootNode.at("/current_weather/temperature").asInt();

System.out.println("Temperature: " + temperature + "°C");
System.out.println("Weather: " + weatherDescription);
Use this example as a reference to parse the temperature and weather description in your implementation.
    
```

#### WmoCodes

WmO Codes are represented as ``Integers``, we need the corresponding ``String``.
Retrieve the ``Integer`` and use WmoCodes to get the corresponding ``String``.



### Part 1: Using ``Future``

1. Create a ``WeatherService`` class with a method ``fetchTemperature(String location)`` that:

   - Fetches temperature data for a given location using the provided ``ApiClient`` class.

   - Uses ExecutorService to run the task asynchronously and returns a Future<Integer>.

2. Create a main method to:

   - Use the fetchTemperature method with three predefined locations, those are given in the main method.

   - Use Future#get to retrieve the temperatures and calculate the average temperature.

   - Print the average temperature.

### Part 2: Using CompletableFuture

1. Update the WeatherService class to include a method fetchTemperatureAsync(String location) that:

   - Fetches temperature data for a given location using the provided ApiClient class.

   - Returns a CompletableFuture<Integer>.

2. Create a method fetchAverageTemperature() that:

    - Uses CompletableFuture to fetch temperatures from three predefined locations in parallel.

    - Combines the results to calculate the average temperature.

3. Modify the main method to:

    - Call the fetchAverageTemperature() method.

    - Print the average temperature once all tasks are completed.


### Part 3: Extending with Weather Descriptions

1. Add another method fetchWeatherDescriptionAsync(String location) that:

   - Fetches a weather description (e.g., sunny, rainy) for a given location using the ApiClient class.

   - Returns a CompletableFuture<String>.

2. Create a method fetchWeatherSummary() that:

    - Uses CompletableFuture to fetch both temperature and description for each location.

    - Combines the temperature and description results into a single formatted string (e.g., "Location 1: 24°C, Sunny").

Modify the main method to call fetchWeatherSummary() and print the results.