package dushenin.oleksii.microservices.recommendations.web;

import dushenin.oleksii.microservices.recommendations.service.RecommendationsService;
import dushenin.oleksii.microservices.recommendations.web.dto.RecommendationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Slf4j
@RestController
@RequestMapping("recommendations")
public class RecommendationsController {

    private final RecommendationsService recommendationsService;

    @Autowired
    public RecommendationsController(RecommendationsService recommendationsService) {
        this.recommendationsService = recommendationsService;
    }

    @RequestMapping(value = "/movies/{id}", method = GET)
    public RecommendationDto findRecommendations(@PathVariable("id") Long id) {
        log.info("Searching recommendations for movie '{}' ...", id);

        if (Math.random() > 0.5) {
            try {
                log.info("Long running service ...");
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        }

        return RecommendationDto.builder()
                .id(id)
                .recommendations(recommendationsService.findRecommendations(id))
                .build();
    }

}
