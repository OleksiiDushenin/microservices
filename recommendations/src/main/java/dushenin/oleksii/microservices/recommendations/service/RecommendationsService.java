package dushenin.oleksii.microservices.recommendations.service;

import java.util.List;

public interface RecommendationsService {
    List<Long> findRecommendations(Long id);
}
