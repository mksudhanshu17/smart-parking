package com.system.smartparking.admin.service;

import com.system.smartparking.user.dto.RegisterUserRequest;
import com.system.smartparking.user.dto.UserResponse;
import com.system.smartparking.user.entity.Role;
import com.system.smartparking.user.entity.User;
import com.system.smartparking.user.mapper.UserMapper;
import com.system.smartparking.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    public UserResponse createManager (RegisterUserRequest request){
        User user = userMapper.mapToUser(request);
        user.setRole(Role.MANAGER);
        userRepository.save(user);

        return userMapper.mapToResponse(user);
    }
}
