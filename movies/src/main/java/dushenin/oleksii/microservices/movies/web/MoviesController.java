package dushenin.oleksii.microservices.movies.web;

import dushenin.oleksii.microservices.movies.service.MoviesService;
import dushenin.oleksii.microservices.movies.web.dto.MovieDto;
import dushenin.oleksii.microservices.movies.web.exception.MovieNotFoundException;
import dushenin.oleksii.microservices.movies.web.mapper.MoviesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    private final MoviesService moviesService;
    private final MoviesMapper moviesMapper;

    @Autowired
    public MoviesController(MoviesService moviesService, MoviesMapper moviesMapper) {
        this.moviesService = moviesService;
        this.moviesMapper = moviesMapper;
    }

    @RequestMapping(method = GET)
    public List<MovieDto> findAll() {
        return moviesMapper.toDto(moviesService.findAll());
    }

    @RequestMapping(value = "/{id}", method = GET)
    public MovieDto findOne(@PathVariable("id") Long id) {
        return moviesService.findOne(id)
                .map(moviesMapper::toDto)
                .orElseThrow(() -> new MovieNotFoundException(id));
    }

    @RequestMapping(value = "/{id}/recommendations", method = GET)
    public List<MovieDto> findRecommendations(@PathVariable("id") Long id) {
        return moviesMapper.toDto(moviesService.findRecommendations(id));
    }

}
