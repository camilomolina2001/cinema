package co.com.poli.showtimeservice.model;

import lombok.Data;

@Data
public class Movies {
    private Long id;
    private String title;
    private String director;
    private int rating;
}
