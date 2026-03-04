package dev.shaikhmahad.fitness.dto.response;

import dev.shaikhmahad.fitness.enums.ActivityType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActivityResponse {

    private UserResponse user;

    private Long id;

    private Integer duration;

    private Integer caloriesBurned;

    private LocalDateTime startTime;

    private ActivityType type;

    private Map<String, Object> additionalMetrics;
}
