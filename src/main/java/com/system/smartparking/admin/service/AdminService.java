package com.system.smartparking.admin.service;

import com.system.smartparking.user.dto.RegisterUserRequest;
import com.system.smartparking.user.dto.UserResponse;

public interface AdminService {
    UserResponse createManager (RegisterUserRequest request);
}
