package dev.shaikhmahad.fitness.services.impl;

import dev.shaikhmahad.fitness.dto.request.ActivityCreateRequest;
import dev.shaikhmahad.fitness.dto.response.ActivityResponse;
import dev.shaikhmahad.fitness.entities.Activity;
import dev.shaikhmahad.fitness.entities.User;
import dev.shaikhmahad.fitness.exceptions.ResourceNotFoundException;
import dev.shaikhmahad.fitness.mappers.ActivityMapper;
import dev.shaikhmahad.fitness.repositories.ActivityRepository;
import dev.shaikhmahad.fitness.repositories.UserRepository;
import dev.shaikhmahad.fitness.services.ActivityService;
import dev.shaikhmahad.fitness.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;
    private final ActivityMapper activityMapper;
    private final UserRepository userRepository;

    @Override
    public ActivityResponse createActivity(ActivityCreateRequest request) {
        Activity activity = activityMapper.toEntity(request);
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", request.getUserId()));
        activity.setUser(user);
        Activity savedActivity = activityRepository.save(activity);
        return activityMapper.toResponse(savedActivity);
    }

    @Override
    public ActivityResponse getActivityById(Long activityId) {
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new ResourceNotFoundException("Activity", "id", activityId));
        return activityMapper.toResponse(activity);
    }

    @Override
    public List<ActivityResponse> getAllActivities(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        List<Activity> activities = activityRepository.findAllByUser(user);
        return activities.stream().map(activityMapper::toResponse).toList();
    }

    @Override
    public void deleteActivity(Long activityId) {
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new ResourceNotFoundException("Activity", "id", activityId));
        activityRepository.delete(activity);
    }
}
