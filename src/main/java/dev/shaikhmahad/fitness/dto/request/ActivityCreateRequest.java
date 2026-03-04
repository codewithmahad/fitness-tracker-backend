package dev.shaikhmahad.fitness.dto.request;


import dev.shaikhmahad.fitness.enums.ActivityType;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivityCreateRequest {

    @NotNull(message = "User ID cannot be null")
    private Long userId;

    @NotNull
    @Positive(message = "Duration must be a positive number")
    @Min(value = 1, message = "Duration must be at least 1 minute")
    private Integer duration;

    @NotNull
    @PositiveOrZero(message = "Calories burned must be a non-negative number")
    private Integer caloriesBurned;

    @NotNull(message = "Start time cannot be null")
    private LocalDateTime startTime;

    @NotNull(message = "Type cannot be null")
    private ActivityType type;

    private Map<String, Object> additionalMetrics;
}
