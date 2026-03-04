package dev.shaikhmahad.fitness.mappers;

import dev.shaikhmahad.fitness.dto.request.ActivityCreateRequest;
import dev.shaikhmahad.fitness.dto.response.ActivityResponse;
import dev.shaikhmahad.fitness.entities.Activity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",uses = {UserMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ActivityMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "recommendations", ignore = true)
    public Activity toEntity(ActivityCreateRequest activityCreateRequest);


    public ActivityResponse toResponse(Activity activity);
}
