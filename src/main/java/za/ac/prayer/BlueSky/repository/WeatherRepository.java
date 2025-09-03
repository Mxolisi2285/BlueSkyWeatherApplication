package za.ac.prayer.BlueSky.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.prayer.BlueSky.model.WeatherRecord;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherRecord, Long> {

    // Fetch all records for a city, sorted by most recent first
    List<WeatherRecord> findByCityOrderByTimestampDesc(String city);

    // Fetch records for a city after a certain timestamp (e.g., last N hours)
    List<WeatherRecord> findByCityAndTimestampAfter(String city, LocalDateTime timestamp);
}
