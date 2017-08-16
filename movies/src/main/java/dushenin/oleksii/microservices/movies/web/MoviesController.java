package dushenin.oleksii.microservices.movies.web;

import dushenin.oleksii.microservices.movies.web.dto.MovieDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    @RequestMapping(method = GET)
    public List<MovieDto> findAll() {
        return emptyList();
    }

    @RequestMapping(value = "/{id}", method = GET)
    public MovieDto findOne(@PathVariable("id") Long id) {
        return new MovieDto();
    }

    @RequestMapping(value = "/{id}/recommendations", method = GET)
    public List<MovieDto> findRecommendations() {
        return emptyList();
    }

}
