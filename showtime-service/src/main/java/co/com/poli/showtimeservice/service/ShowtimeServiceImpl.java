package co.com.poli.showtimeservice.service;

import co.com.poli.showtimeservice.clientFeign.MovieClient;
import co.com.poli.showtimeservice.model.Movies;
import co.com.poli.showtimeservice.persistence.entity.Showtime;
import co.com.poli.showtimeservice.persistence.repository.ShowtimeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowtimeServiceImpl implements ShowtimeService {

    private final ShowtimeRepository showtimeRepository;
    private final MovieClient movieClient;

    @Override
    public void save(Showtime showtime) {
        showtimeRepository.save(showtime);
    }

    @Override
    public void delete(Showtime showtime) {
    showtimeRepository.delete(showtime);
    }

    @Override
    public List<Showtime> findAll() {
        return showtimeRepository.findAll();
    }

    @Override
    public Showtime findById(Long id) {
        return showtimeRepository.findById(id).orElse(null);
    }

    @Override
    public Showtime findByshowtimeId(Long showtimeID) {
        Showtime showtime = showtimeRepository.findByShowtimeId(showtimeID);
        ModelMapper modelMapper = new ModelMapper();
        Movies movies =
                modelMapper.map(movieClient.findByID(showtime.getMovieId()).getData(), Movies.class);
        showtime.setMovies(movies);
        return showtime;
    }
}
