package dev.shaikhmahad.fitness.services.impl;

import dev.shaikhmahad.fitness.dto.request.UserRegistrationRequest;
import dev.shaikhmahad.fitness.dto.request.UserUpdateRequest;
import dev.shaikhmahad.fitness.dto.response.UserResponse;
import dev.shaikhmahad.fitness.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserResponse createUser(UserRegistrationRequest userRegistrationRequest) {
        return null;
    }

    @Override
    public UserResponse updateUser(UserUpdateRequest userUpdateRequest, Long userId) {
        return null;
    }

    @Override
    public void deleteUser(Long userId) {

    }

    @Override
    public List<UserResponse> getAllUsers() {
        return List.of();
    }

    @Override
    public UserResponse registerNewUser(UserRegistrationRequest userRegistrationRequest) {
        return null;
    }
}
