package dev.shaikhmahad.fitness.repositories;

import dev.shaikhmahad.fitness.entities.Activity;
import dev.shaikhmahad.fitness.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

    // Fetch all activities for a specific user.
    Page<Activity> findByUserId(Long userId, Pageable pageable);

    // Checks if an activity belongs to a specific user (Security check)
    boolean existsByIdAndUserId(Long activityId, Long userId);

    List<Activity> findAllByUser(User user);
}
