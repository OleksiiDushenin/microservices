package dushenin.oleksii.microservices.movies.web.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RecommendationDto {
    private Long id;
    private List<Long> recommendations = new ArrayList<>();
}
