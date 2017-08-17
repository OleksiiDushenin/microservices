package dushenin.oleksii.microservices.movies.web.exception;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.ResponseStatus;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(NOT_FOUND)
@AllArgsConstructor
public class MovieNotFoundException extends RuntimeException {

    public MovieNotFoundException(Long id) {
        super(format("Movie with id '%d' is not found", id));
    }

}
