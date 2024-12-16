package thro.fpk;

import java.util.HashMap;
import java.util.Map;

public class WmoCodes {

    private static final Map<Integer, String> wmoCodeDescriptions = new HashMap<>();

    static {
        wmoCodeDescriptions.put(0, "Clear sky");
        wmoCodeDescriptions.put(1, "Mainly clear");
        wmoCodeDescriptions.put(2, "Partly cloudy");
        wmoCodeDescriptions.put(3, "Overcast");
        wmoCodeDescriptions.put(45, "Fog");
        wmoCodeDescriptions.put(48, "Depositing rime fog");
        wmoCodeDescriptions.put(51, "Drizzle: Light");
        wmoCodeDescriptions.put(53, "Drizzle: Moderate");
        wmoCodeDescriptions.put(55, "Drizzle: Dense intensity");
        wmoCodeDescriptions.put(56, "Freezing Drizzle: Light");
        wmoCodeDescriptions.put(57, "Freezing Drizzle: Dense intensity");
        wmoCodeDescriptions.put(61, "Rain: Slight");
        wmoCodeDescriptions.put(63, "Rain: Moderate");
        wmoCodeDescriptions.put(65, "Rain: Heavy intensity");
        wmoCodeDescriptions.put(66, "Freezing Rain: Light");
        wmoCodeDescriptions.put(67, "Freezing Rain: Heavy intensity");
        wmoCodeDescriptions.put(71, "Snow fall: Slight");
        wmoCodeDescriptions.put(73, "Snow fall: Moderate");
        wmoCodeDescriptions.put(75, "Snow fall: Heavy intensity");
        wmoCodeDescriptions.put(77, "Snow grains");
        wmoCodeDescriptions.put(80, "Rain showers: Slight");
        wmoCodeDescriptions.put(81, "Rain showers: Moderate");
        wmoCodeDescriptions.put(82, "Rain showers: Violent");
        wmoCodeDescriptions.put(85, "Snow showers: Slight");
        wmoCodeDescriptions.put(86, "Snow showers: Heavy");
        wmoCodeDescriptions.put(95, "Thunderstorm: Slight or moderate");
        wmoCodeDescriptions.put(96, "Thunderstorm with slight hail");
        wmoCodeDescriptions.put(99, "Thunderstorm with heavy hail");
    }

    public static String getDescription(int code) {
        return wmoCodeDescriptions.getOrDefault(code, "Unknown WMO code");
    }
}