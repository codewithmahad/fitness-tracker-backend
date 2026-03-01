package dev.shaikhmahad.fitness.repositories;

import dev.shaikhmahad.fitness.entities.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
    // Fetch the recommendation for a specific activity
    Optional<Recommendation> findByActivityId(Long activityId);
}
