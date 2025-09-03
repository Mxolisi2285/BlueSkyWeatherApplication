package za.ac.prayer.BlueSky.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import za.ac.prayer.BlueSky.model.WeatherRecord;
import za.ac.prayer.BlueSky.service.WeatherHistoryService;

import java.util.List;

@Controller
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherHistoryService weatherService;

    public WeatherController(WeatherHistoryService weatherService) {
        this.weatherService = weatherService;
    }

    /**
     * Show main page
     */
    @GetMapping
    public String index() {
        return "index"; // renders src/main/resources/templates/index.html
    }

    /**
     * Fetch live weather from API and save it
     */
    @PostMapping("/fetch")
    public String fetchAndSave(@RequestParam String city, Model model) {
        WeatherRecord saved = weatherService.fetchAndSaveWeather(city);
        model.addAttribute("weather", saved);
        return "index";
    }

    /**
     * Get full weather history for a city (most recent first)
     */
    @GetMapping("/history")
    public String getWeatherHistory(@RequestParam String city, Model model) {
        List<WeatherRecord> history = weatherService.getWeatherHistory(city);
        model.addAttribute("history", history);
        return "index";
    }

    /**
     * Get weather history for a city in the last N hours
     */
    @GetMapping("/history/last")
    public String getWeatherHistoryLastNHours(
            @RequestParam String city,
            @RequestParam int hours,
            Model model) {
        List<WeatherRecord> recentHistory = weatherService.getWeatherHistoryLastNHours(city, hours);
        model.addAttribute("recentHistory", recentHistory);
        return "index";
    }

    /**
     * Optional: Save a manual weather record
     */
    @PostMapping("/save")
    public String saveWeather(@ModelAttribute WeatherRecord record, Model model) {
        WeatherRecord saved = weatherService.saveWeather(record);
        model.addAttribute("weather", saved);
        return "index";
    }
}
