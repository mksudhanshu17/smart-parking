package com.system.smartparking.user.service;

import com.system.smartparking.user.dto.RegisterUserRequest;
import com.system.smartparking.user.dto.UpdateUserRequest;
import com.system.smartparking.user.dto.UserResponse;
import com.system.smartparking.user.entity.User;
import com.system.smartparking.user.exception.UserAlreadyExistsException;
import com.system.smartparking.user.exception.UserNotFoundException;
import com.system.smartparking.user.mapper.UserMapper;
import com.system.smartparking.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    // Register User
    @Transactional
    public UserResponse registerUser(RegisterUserRequest request){
        if(userRepository.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException("User already registered!");
        }
        User user = userMapper.mapToUser(request);
        userRepository.save(user);
        return userMapper.mapToResponse(user);
    }

    // Find User by User ID
    public UserResponse getUserById(Long id){
      User user  = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User not found!"));
      return userMapper.mapToResponse(user);
    }

    // Find User by email ID;
    public UserResponse getUserByEmail(String email){
       User user = userRepository.findByEmail(email).orElseThrow(()-> new UserNotFoundException("User not found!"));
        return userMapper.mapToResponse(user);
    }

    // Update User
    @Transactional
    public UserResponse updateUser(Long id, UpdateUserRequest request){
        User user = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User does not exist!"));
        userMapper.updateFromRequest(request , user);
       // userRepository.save(user);    not needed as Transactional manages the save
        return userMapper.mapToResponse(user);
    }

    // Delete User
    public void deleteUser(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User does not exist"));
        userRepository.delete(user);
    }


}
