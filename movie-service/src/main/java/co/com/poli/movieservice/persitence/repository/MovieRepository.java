package co.com.poli.movieservice.persitence.repository;

import co.com.poli.movieservice.persitence.entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movies,Long> {
}
