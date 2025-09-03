BlueSky Weather Application

BlueSky is a Spring Boot application that allows users to fetch, view, and store weather information for different cities. It integrates with the OpenWeatherMap API to retrieve live weather data and persists it in an H2 in-memory database. The application features a Thymeleaf frontend, allowing users to interact with the system through forms and tables.

Features

Fetch live weather data from OpenWeatherMap API and store it in the database.

View full weather history for a city, sorted by most recent records.

Filter weather history for a city in the last N hours.

Manual entry of weather records (optional).

Thymeleaf frontend for user-friendly interaction.

Responsive design using separate CSS for styling.

Error handling for invalid API keys or cities, showing friendly messages on the frontend.

Technologies Used

Backend: Spring Boot, Spring MVC, Spring Data JPA

Database: H2 in-memory database

Frontend: Thymeleaf, HTML, CSS

API Integration: OpenWeatherMap API

Java Version: 17+ (or compatible)


Usage

Fetch Live Weather

Enter a city name and click Fetch Weather.

The latest weather data will appear and be saved to the database.

View Full History

Enter a city name and click Get History.

Displays all saved weather records for that city.

View Recent History

Enter a city name and number of hours, then click Get Recent History.

Displays weather records for the last N hours.

Manual Weather Entry (Optional)

Fill in city, temperature, humidity, and description.

Click Save Weather to store the record.
