package co.com.poli.showtimeservice.persistence.repository;

import co.com.poli.showtimeservice.persistence.entity.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {
    Showtime findByShowtimeId(Long showtime);
}
