package co.com.poli.movieservice.service;

import co.com.poli.movieservice.persitence.entity.Movies;

import java.util.List;

public interface MovieService {
    void save(Movies movies);
    void delete(Movies movies);
    List<Movies> findAll();
    Movies findById(Long id);
}
