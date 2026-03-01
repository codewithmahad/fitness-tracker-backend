package dev.shaikhmahad.fitness.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.shaikhmahad.fitness.enums.ActivityType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "activities")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "ENUM('RUNNING', 'CYCLING', 'SWIMMING', 'WALKING', 'GYM')")
    private ActivityType type;

    @Column(nullable = false)
    private Integer duration;

    @Column(name = "calories_burned")
    private Integer caloriesBurned;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "additional_metrics", columnDefinition = "json")
    private Map<String, Object> additionalMetrics;

    @JsonIgnore
    @OneToMany(mappedBy = "activity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Recommendation> recommendations = new ArrayList<>();

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}