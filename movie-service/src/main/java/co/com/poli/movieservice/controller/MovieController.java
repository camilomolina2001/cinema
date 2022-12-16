package co.com.poli.movieservice.controller;

import co.com.poli.movieservice.helpers.Response;
import co.com.poli.movieservice.helpers.ResponseBuild;
import co.com.poli.movieservice.persitence.entity.Movies;
import co.com.poli.movieservice.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController{
    private final MovieService movieService;
    private final ResponseBuild build;

    @PostMapping
    public Response save(@Valid @RequestBody Movies movies, BindingResult result){
        if(result.hasErrors()){
            return build.failed(formatMessage(result));
        }
        movieService.save(movies);
        return build.success(movies);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id){
        Movies movies = movieService.findById(id);
        movieService.delete(movies);
        return build.success(movies);
    }

    @GetMapping
    public Response findAll(){
        return build.success(movieService.findAll());
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id){
        Movies movies = movieService.findById(id);
        return build.success(movies);
    }

    private List<Map<String,String>> formatMessage(BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(error -> {
                    Map<String,String> err = new HashMap<>();
                    err.put(error.getField(),error.getDefaultMessage());
                    return err;
                }).collect(Collectors.toList());
        return errors;
    }
}
