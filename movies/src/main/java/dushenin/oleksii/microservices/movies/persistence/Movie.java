package dushenin.oleksii.microservices.movies.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Movie {
    private Long id;
    private String name;
    private String country;
    private Integer year;
    private String description;
}
