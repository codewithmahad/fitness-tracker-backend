package dev.shaikhmahad.fitness.controllers;


import dev.shaikhmahad.fitness.dto.request.UserRegistrationRequest;
import dev.shaikhmahad.fitness.dto.response.UserResponse;
import dev.shaikhmahad.fitness.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 1. REGISTER A NEW USER
    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody UserRegistrationRequest request) {
        UserResponse response = userService.registerNewUser(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED); // 201 Created
    }

    // 2. GET A SINGLE USER BY ID
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable("id") Long userId) {
        UserResponse response = userService.getUserById(userId);
        return new ResponseEntity<>(response, HttpStatus.OK); // 200 OK
    }
    
}
