package za.ac.prayer.BlueSky.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import za.ac.prayer.BlueSky.client.WeatherApiClient;
import za.ac.prayer.BlueSky.model.WeatherRecord;
import za.ac.prayer.BlueSky.repository.WeatherRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WeatherHistoryService {

    private static final Logger logger = LoggerFactory.getLogger(WeatherHistoryService.class);

    private final WeatherRepository repository;
    private final WeatherApiClient apiClient;

    public WeatherHistoryService(WeatherRepository repository, WeatherApiClient apiClient) {
        this.repository = repository;
        this.apiClient = apiClient;
    }

    /**
     * Save a weather record manually
     */
    public WeatherRecord saveWeather(WeatherRecord record) {
        if (record.getCity() == null || record.getCity().isEmpty()) {
            throw new IllegalArgumentException("City cannot be empty");
        }

        record.setTimestamp(LocalDateTime.now());
        WeatherRecord saved = repository.save(record);
        logger.info("Saved weather record: {}", saved);
        return saved;
    }

    /**
     * Fetch weather from external API and save to database
     */
    public WeatherRecord fetchAndSaveWeather(String city) {
        WeatherRecord record = apiClient.fetchWeather(city);
        if (record != null) {
            record.setTimestamp(LocalDateTime.now());
            WeatherRecord saved = repository.save(record);
            logger.info("Fetched and saved weather record: {}", saved);
            return saved;
        } else {
            logger.warn("Failed to fetch weather for city: {}", city);
            return null;
        }
    }

    /**
     * Get full weather history for a city (most recent first)
     */
    public List<WeatherRecord> getWeatherHistory(String city) {
        if (city == null || city.isEmpty()) {
            throw new IllegalArgumentException("City cannot be empty");
        }
        List<WeatherRecord> history = repository.findByCityOrderByTimestampDesc(city);
        logger.info("Fetched {} weather records for city: {}", history.size(), city);
        return history;
    }

    /**
     * Get weather history for a city in the last N hours
     */
    public List<WeatherRecord> getWeatherHistoryLastNHours(String city, int hours) {
        if (city == null || city.isEmpty()) {
            throw new IllegalArgumentException("City cannot be empty");
        }
        LocalDateTime since = LocalDateTime.now().minusHours(hours);
        List<WeatherRecord> history = repository.findByCityAndTimestampAfter(city, since);
        logger.info("Fetched {} weather records for city: {} in the last {} hours", history.size(), city, hours);
        return history;
    }
}
