package co.com.poli.showtimeservice.service;

import co.com.poli.showtimeservice.persistence.entity.Showtime;

import java.util.List;

public interface ShowtimeService {
    void save(Showtime showtime);
    void delete(Showtime showtime);
    List<Showtime> findAll();
    Showtime findById(Long id);
    Showtime findByshowtimeId(Long showtimeID);
}
