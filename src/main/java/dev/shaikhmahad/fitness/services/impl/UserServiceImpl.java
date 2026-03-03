package dev.shaikhmahad.fitness.services.impl;

import dev.shaikhmahad.fitness.dto.request.UserRegistrationRequest;
import dev.shaikhmahad.fitness.dto.request.UserUpdateRequest;
import dev.shaikhmahad.fitness.dto.response.UserResponse;
import dev.shaikhmahad.fitness.entities.User;
import dev.shaikhmahad.fitness.enums.UserRole;
import dev.shaikhmahad.fitness.exceptions.ResourceNotFoundException;
import dev.shaikhmahad.fitness.mappers.UserMapper;
import dev.shaikhmahad.fitness.repositories.UserRepository;
import dev.shaikhmahad.fitness.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public UserResponse registerNewUser(UserRegistrationRequest userRegistrationRequest) {

        User user = userMapper.toEntity(userRegistrationRequest);
        if(userRepository.existsByEmail(user.getEmail())){
            throw new ResourceAlreadyExistsException("Email is already taken");
        }
        user.setUserRole(UserRole.USER);
        User savedUser = userRepository.save(user);
        return userMapper.toResponse(savedUser);
    }

    @Override
    public UserResponse updateUser(UserUpdateRequest userUpdateRequest, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        if(userRepository.existsByEmail(user.getEmail())){
            throw new ResourceAlreadyExistsException("Email is already taken");
        }
        user.setFirstName(userUpdateRequest.getFirstName());
        user.setLastName(userUpdateRequest.getLastName());
        user.setEmail(userUpdateRequest.getEmail());

        User savedUser = userRepository.save(user);
        return userMapper.toResponse(savedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        this.userRepository.delete(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {

        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::toResponse)
                .toList();
    }

    @Override
    public UserResponse getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        return  userMapper.toResponse(user);
    }


}
