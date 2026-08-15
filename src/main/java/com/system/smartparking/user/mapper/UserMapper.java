package com.system.smartparking.user.mapper;

import com.system.smartparking.user.dto.RegisterUserRequest;
import com.system.smartparking.user.dto.UserResponse;
import com.system.smartparking.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User mapToUser (RegisterUserRequest request){
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setPassword(request.getPassword());
        return user;
    }

    public UserResponse mapToResponse(User user){
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setName(user.getName());
        userResponse.setEmail(user.getEmail());
        userResponse.setPhone(user.getPhone());
        userResponse.setStatus(user.getStatus());
        userResponse.setRole(user.getRole());
        return userResponse;
    }
}
