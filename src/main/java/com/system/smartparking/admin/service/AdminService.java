package com.system.smartparking.admin.service;

import com.system.smartparking.user.dto.RegisterUserRequest;
import com.system.smartparking.user.dto.UserResponse;

import java.util.List;

public interface AdminService {
    UserResponse createManager (RegisterUserRequest request);

    void deactivateUser (Long id);

    void activateUser (Long id);

    void deactivateManager (Long id);

    void activateManager (Long id);

    void blockUser (Long id);

    void blockManager (Long id);

    List<UserResponse> getAllManagers ();



}
