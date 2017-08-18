package dushenin.oleksii.microservices.movies.service.impl;

import dushenin.oleksii.microservices.movies.persistence.Movie;
import dushenin.oleksii.microservices.movies.persistence.repository.MoviesRepository;
import dushenin.oleksii.microservices.movies.service.MoviesService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.web.util.UriComponentsBuilder.fromHttpUrl;

@Service
public class MoviesServiceImpl implements MoviesService {
    // TODO externalize
    private String recommendationsKey = "recommendations";
    private final MoviesRepository repository;
    private final RestTemplate restTemplate;

    @Autowired
    public MoviesServiceImpl(MoviesRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
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
        return restTemplate.exchange(
                fromHttpUrl("http://" + recommendationsKey + "/recommendations/movies/{id}")
                        .buildAndExpand(id)
                        .toUriString(),
                GET,
                new HttpEntity(new HttpHeaders()),
                Recommendation.class)
                .getBody().getRecommendations();
    }

    @Data
    private static class Recommendation {
        private Long id;
        private List<Long> recommendations;
    }

}
