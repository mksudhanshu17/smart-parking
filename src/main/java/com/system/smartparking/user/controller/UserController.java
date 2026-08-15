package com.system.smartparking.user.controller;

import com.system.smartparking.user.dto.RegisterUserRequest;
import com.system.smartparking.user.dto.UpdateUserRequest;
import com.system.smartparking.user.dto.UserResponse;
import com.system.smartparking.user.entity.User;
import com.system.smartparking.user.mapper.UserMapper;
import com.system.smartparking.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;


    @PostMapping
    public ResponseEntity<UserResponse> registerUser(@RequestBody RegisterUserRequest request){
        UserResponse response = userService.registerUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable  Long id){
        UserResponse response = userService.getUserById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("email/{email}")
    public ResponseEntity<UserResponse> getUserByEmail(@PathVariable String email){
        UserResponse response = userService.getUserByEmail(email);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody  UpdateUserRequest request){
        UserResponse response = userService.updateUser(id, request);
        return ResponseEntity.ok(response);
    }

}
