package dushenin.oleksii.microservices.movies.web.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovieDto {
    private Long id;
    private String name;
    private String country;
    private Integer year;
    private String description;
}
