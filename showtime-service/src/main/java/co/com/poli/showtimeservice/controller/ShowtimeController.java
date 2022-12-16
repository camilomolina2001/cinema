package co.com.poli.showtimeservice.controller;

import co.com.poli.showtimeservice.helpers.Response;
import co.com.poli.showtimeservice.helpers.ResponseBuild;
import co.com.poli.showtimeservice.persistence.entity.Showtime;
import co.com.poli.showtimeservice.service.ShowtimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/showtimes")
@RequiredArgsConstructor
public class ShowtimeController {

    private final ShowtimeService showtimeService;
    private final ResponseBuild builder;

    @PostMapping()
    public Response save(@RequestBody Showtime showtime, BindingResult result) {
        if (result.hasErrors()) {
            return builder.failed(formatMessage(result));
        }
        showtimeService.save(showtime);
        return builder.success(showtime);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id) {
        Showtime showtime = showtimeService.findByshowtimeId(id);
        if (showtime == null) {
            return builder.failed(showtime);
        }
        return builder.success(showtime);
    }

    @GetMapping("/{id}")
    public Response getById(@PathVariable("id") Long numberInvoice) {
        Showtime showtime = showtimeService.findByshowtimeId(numberInvoice);
        if (showtime == null) {
            return builder.success();
        }
        return builder.success(showtime);
    }

    private List<Map<String, String>> formatMessage(BindingResult result) {
        List<Map<String, String>> errors = result.getFieldErrors().stream()
                .map(error -> {
                    Map<String, String> err = new HashMap<>();
                    err.put(error.getField(), error.getDefaultMessage());
                    return err;
                }).collect(Collectors.toList());
        return errors;
    }
}
