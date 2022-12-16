package co.com.poli.showtimeservice.clientFeign;


import co.com.poli.showtimeservice.helpers.Response;
import co.com.poli.showtimeservice.helpers.ResponseBuild;
import co.com.poli.showtimeservice.model.Movies;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieClientImplHystrixFallBack implements MovieClient{

    private final ResponseBuild build;


    @Override
    public Response findByShowtimeID(String movieID) {
        return build.success(new Movies());
    }

    @Override
    public Response findByID(Long id) {
        return build.success(new Movies());
    }

}
