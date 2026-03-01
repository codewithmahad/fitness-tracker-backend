package dev.shaikhmahad.fitness.repositories;

import dev.shaikhmahad.fitness.entities.Activity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

    // Fetch all activities for a specific user.
    Page<Activity> findByUserId(Long userId, Pageable pageable);

    // Checks if an activity belongs to a specific user (Security check)
    boolean existsByIdAndUserId(Long activityId, Long userId);
}
