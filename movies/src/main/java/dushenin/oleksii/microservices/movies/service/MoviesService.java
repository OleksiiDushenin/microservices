package dushenin.oleksii.microservices.movies.service;

import dushenin.oleksii.microservices.movies.persistence.Movie;

import java.util.List;
import java.util.Optional;

public interface MoviesService {
    List<Movie> findAll();

    Optional<Movie> findOne(Long id);

    List<Movie> findRecommendations(Long id);
}
