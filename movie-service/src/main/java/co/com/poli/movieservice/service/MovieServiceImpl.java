package co.com.poli.movieservice.service;

import co.com.poli.movieservice.persitence.entity.Movies;
import co.com.poli.movieservice.persitence.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService{

    private final MovieRepository movieRepository;

    @Override
    public void save(Movies movies) {
        movieRepository.save(movies);
    }

    @Override
    public void delete(Movies movies) {
        movieRepository.delete(movies);
    }

    @Override
    public List<Movies> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movies findById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }
}
