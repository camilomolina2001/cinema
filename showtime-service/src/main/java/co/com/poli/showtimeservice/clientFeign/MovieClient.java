package co.com.poli.showtimeservice.clientFeign;

import co.com.poli.showtimeservice.helpers.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "movie-service", fallback = MovieClientImplHystrixFallBack.class)
public interface MovieClient {
    @GetMapping("/cinema/api/v1/movies/id/{ID}")
    Response findByShowtimeID(@PathVariable("movieID") String movieID);

    @GetMapping("/cinema/api/v1/movies/{ID}")
    Response findByID(@PathVariable("ID") Long id);
}
