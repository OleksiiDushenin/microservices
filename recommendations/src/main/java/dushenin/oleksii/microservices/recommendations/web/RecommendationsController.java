package dushenin.oleksii.microservices.recommendations.web;

import dushenin.oleksii.microservices.recommendations.service.RecommendationsService;
import dushenin.oleksii.microservices.recommendations.web.dto.RecommendationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

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
        return RecommendationDto.builder()
                .id(id)
                .recommendations(recommendationsService.findRecommendations(id))
                .build();
    }

}
