package dushenin.oleksii.microservices.movies.web.mapper;

import dushenin.oleksii.microservices.movies.persistence.Movie;
import dushenin.oleksii.microservices.movies.web.dto.MovieDto;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class MoviesMapper {

    public MovieDto toDto(Movie movie) {
        return MovieDto.builder()
                .id(movie.getId())
                .name(movie.getName())
                .country(movie.getCountry())
                .year(movie.getYear())
                .description(movie.getDescription())
                .build();
    }

    public List<MovieDto> toDto(List<Movie> movies) {
        return movies.stream()
                .map(this::toDto)
                .collect(toList());
    }

}
