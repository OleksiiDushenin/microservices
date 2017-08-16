package dushenin.oleksii.microservices.movies.web.exception;

import lombok.AllArgsConstructor;

import static java.lang.String.format;

@AllArgsConstructor
public class MovieNotFoundException extends RuntimeException {

    public MovieNotFoundException(Long id) {
        super(format("Movie with id '%d' is not found", id));
    }

}
