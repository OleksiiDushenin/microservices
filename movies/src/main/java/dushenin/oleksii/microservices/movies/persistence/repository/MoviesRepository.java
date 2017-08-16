package dushenin.oleksii.microservices.movies.persistence.repository;

import dushenin.oleksii.microservices.movies.persistence.Movie;

import java.util.List;
import java.util.Optional;

public interface MoviesRepository {
    Optional<Movie> findOne(Long id);

    List<Movie> findAll();

    List<Movie> findAll(List<Long> ids);
}
