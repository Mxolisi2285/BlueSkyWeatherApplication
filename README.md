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
