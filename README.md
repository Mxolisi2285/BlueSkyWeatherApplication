BlueSky Weather Application

BlueSky is a Spring Boot application that allows users to fetch, view, and store weather information for different cities. It integrates with the OpenWeatherMap API to retrieve live weather data and stores it in an H2 in-memory database. The application includes a Thymeleaf frontend for dynamic interaction and displays weather history in a user-friendly format.

Features

Fetch live weather data from OpenWeatherMap and save it to the database.

View full weather history for a city, sorted by most recent records.

Filter weather history for a city in the last N hours.

Manual entry of weather records (optional).

Responsive frontend using Thymeleaf and CSS.

Error handling for invalid API keys or cities, showing user-friendly messages.

Technologies Used

Backend: Spring Boot, Spring MVC, Spring Data JPA

Database: H2 in-memory

Frontend: Thymeleaf, HTML, CSS

API Integration: OpenWeatherMap API

How to Run the Application

Clone the repository and navigate into the project folder. Configure your OpenWeatherMap API key either directly in application.properties (weather.api.key=YOUR_API_KEY_HERE) or, preferably, as an environment variable (WEATHER_API_KEY). Build and run the application using Maven (mvn clean install and mvn spring-boot:run) or your IDE by running BlueSkyApplication.java. Access the frontend at http://localhost:8080/weather to interact with forms and view weather history, or use the API endpoints (/api/weather/history/{city}, /api/weather/fetch/{city}). The H2 console is available at http://localhost:8080/h2-console to inspect stored records.

Database

H2 in-memory database (no setup required).

H2 Console: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:testdb

Future Improvements

Deploy to a cloud platform (Render, Railway, Fly.io) for live access.

Enable user authentication for personalized weather tracking.

Add charts and visualizations for weather trends.

Switch to a persistent database (PostgreSQL/MySQL) for production.

User: sa

Password: (leave blank)
