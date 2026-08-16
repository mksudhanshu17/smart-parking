package com.system.smartparking.user.service;

import com.system.smartparking.user.dto.RegisterUserRequest;
import com.system.smartparking.user.dto.UpdateUserRequest;
import com.system.smartparking.user.dto.UserResponse;

public interface UserService {
     UserResponse registerUser(RegisterUserRequest request);

    UserResponse getUserById(Long id);

    UserResponse getUserByEmail(String email);

    UserResponse updateUser(Long id, UpdateUserRequest request);

    void deleteUser(Long id);
}
