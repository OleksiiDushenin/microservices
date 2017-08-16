package dushenin.oleksii.microservices.movies.service.impl;

import dushenin.oleksii.microservices.movies.persistence.Movie;
import dushenin.oleksii.microservices.movies.persistence.repository.MoviesRepository;
import dushenin.oleksii.microservices.movies.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;

@Service
public class MoviesServiceImpl implements MoviesService {

    private final MoviesRepository repository;

    @Autowired
    public MoviesServiceImpl(MoviesRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Movie> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Movie> findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Movie> findRecommendations(Long id) {
        final List<Long> ids = queryForRecommendations(id);
        if (ids.isEmpty()) {
            return emptyList();
        }

        return repository.findAll(ids);
    }

    private List<Long> queryForRecommendations(Long id) {
        return emptyList();
    }

}
