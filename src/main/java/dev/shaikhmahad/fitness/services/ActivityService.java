package dev.shaikhmahad.fitness.services;

import dev.shaikhmahad.fitness.dto.request.ActivityCreateRequest;
import dev.shaikhmahad.fitness.dto.response.ActivityResponse;

import java.util.List;

public interface ActivityService {

    ActivityResponse createActivity(ActivityCreateRequest request);

    ActivityResponse getActivityById(Long activityId);

    List<ActivityResponse> getAllActivities(Long userId);

    void deleteActivity(Long activityId);
}
