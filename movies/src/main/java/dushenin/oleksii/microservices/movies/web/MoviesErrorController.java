package dushenin.oleksii.microservices.movies.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class MoviesErrorController implements ErrorController {

    private final ErrorAttributes errorAttributes;

    @Autowired
    public MoviesErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        final Map<String, Object> attributes = getAttributes(request);
        return new ResponseEntity<>(attributes, getStatus(attributes));
    }

    private HttpStatus getStatus(Map<String, Object> attributes) {
        return HttpStatus.valueOf((Integer) attributes.get("status"));
    }

    private Map<String, Object> getAttributes(HttpServletRequest request) {
        return errorAttributes.getErrorAttributes(new ServletRequestAttributes(request), true);
    }

}
