package dushenin.oleksii.microservices.movies.persistence.repository.impl;

import dushenin.oleksii.microservices.movies.persistence.Movie;
import dushenin.oleksii.microservices.movies.persistence.repository.MoviesRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;

@Repository
public class MoviesRepositoryImpl implements MoviesRepository {

    private final Map<Long, Movie> data;

    public MoviesRepositoryImpl() {
        final Map<Long, Movie> movies = IntStream.range(1, 11)
                .mapToObj(value ->
                        new Movie((long) value, "Name " + value, "US", 1990 + value, "Description " + value))
                .collect(
                        toMap(
                                Movie::getId,
                                Function.identity()
                        )
                );

        data = Collections.unmodifiableMap(movies);
    }

    @Override
    public Optional<Movie> findOne(Long id) {
        return Optional.ofNullable(data.get(id));
    }

    @Override
    public List<Movie> findAll() {
        return new ArrayList<>(data.values());
    }

    @Override
    public List<Movie> findAll(List<Long> ids) {
        final Map<Long, Movie> foundMovies = new HashMap<>(data);
        foundMovies.keySet().retainAll(ids);

        return new ArrayList<>(foundMovies.values());
    }

}
