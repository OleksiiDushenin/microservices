package dushenin.oleksii.microservices.recommendations.web.dto;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class RecommendationDto {
    private Long id;
    private List<Long> recommendations = new ArrayList<>();
}
