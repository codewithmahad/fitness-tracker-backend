package dev.shaikhmahad.fitness.mappers;


import dev.shaikhmahad.fitness.dto.request.UserRegistrationRequest;
import dev.shaikhmahad.fitness.dto.response.UserResponse;
import dev.shaikhmahad.fitness.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring" , unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface UserMapper {

    @Mapping(target = "id" , ignore = true)
    @Mapping(target = "createdAt" , ignore = true)
    @Mapping(target = "updatedAt" , ignore = true)
    @Mapping(target = "userRole" , ignore = true)
    public User toEntity(UserRegistrationRequest request);

    public UserResponse toResponse(User user);
}
