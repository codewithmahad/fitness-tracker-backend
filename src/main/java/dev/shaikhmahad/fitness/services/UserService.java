package dev.shaikhmahad.fitness.services;

import dev.shaikhmahad.fitness.dto.request.UserRegistrationRequest;
import dev.shaikhmahad.fitness.dto.request.UserUpdateRequest;
import dev.shaikhmahad.fitness.dto.response.UserResponse;
import dev.shaikhmahad.fitness.repositories.UserRepository;

import java.util.List;

public interface UserService {


    UserResponse registerNewUser(UserRegistrationRequest userRegistrationRequest);

    UserResponse updateUser(UserUpdateRequest userUpdateRequest, Long userId);

    void deleteUser(Long userId);

    List<UserResponse> getAllUsers();

    UserResponse getUserById(Long userId);

}
