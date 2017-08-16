package dushenin.oleksii.microservices.recommendations.service.impl;

import dushenin.oleksii.microservices.recommendations.service.RecommendationsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;

@Service
public class RecommendationsServiceImpl implements RecommendationsService {

    private static final long NUMBER_OF_RECOMMENDATIONS = 5;
    private static final long FROM_BOUND = 1;
    private static final long TO_BOUND = 10;

    @Override
    public List<Long> findRecommendations(Long id) {
        return new Random()
                .longs(FROM_BOUND, TO_BOUND + 1)
                .filter(v -> !id.equals(v))
                .limit(NUMBER_OF_RECOMMENDATIONS)
                .boxed()
                .collect(toList());
    }

}
