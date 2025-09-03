package za.ac.prayer.BlueSky.client;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import za.ac.prayer.BlueSky.model.WeatherRecord;

@Component
public class WeatherApiClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String API_KEY = "cd2cdd165a61e58ed22487f47d79a6c3"; // Replace with your key
    private final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather?q=%s&units=metric&appid=%s";

    public WeatherRecord fetchWeather(String city) {
        String url = String.format(BASE_URL, city, API_KEY);
        JsonNode response = restTemplate.getForObject(url, JsonNode.class);

        if (response != null) {
            WeatherRecord record = new WeatherRecord();
            record.setCity(city);
            record.setDescription(response.get("weather").get(0).get("description").asText());
            record.setTemperature(response.get("main").get("temp").asDouble());
            record.setHumidity(response.get("main").get("humidity").asDouble());
            return record;
        }
        return null;
    }
}
