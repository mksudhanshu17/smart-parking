package com.system.smartparking.user.service;

import com.system.smartparking.user.dto.RegisterUserRequest;
import com.system.smartparking.user.dto.UpdateUserRequest;
import com.system.smartparking.user.dto.UserResponse;
import com.system.smartparking.user.entity.User;
import com.system.smartparking.exception.ResourceAlreadyExistsException;
import com.system.smartparking.exception.ResourceNotFoundException;
import com.system.smartparking.user.mapper.UserMapper;
import com.system.smartparking.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    // Register User
    @Transactional
    public UserResponse registerUser(RegisterUserRequest request){
        if(userRepository.existsByEmail(request.getEmail())) {
            throw new ResourceAlreadyExistsException("User already registered!");
        }
        User user = userMapper.mapToUser(request);
        userRepository.save(user);
        return userMapper.mapToResponse(user);
    }

    // Find User by User ID
    public UserResponse getUserById(Long id){
      User user  = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found!"));
      return userMapper.mapToResponse(user);
    }

    // Find User by email ID;
    public UserResponse getUserByEmail(String email){
       User user = userRepository.findByEmail(email).orElseThrow(()-> new ResourceNotFoundException("User not found!"));
        return userMapper.mapToResponse(user);
    }

    // Update User
    @Transactional
    public UserResponse updateUser(Long id, UpdateUserRequest request){
        User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User does not exist!"));
        userMapper.updateFromRequest(request , user);
       // userRepository.save(user);    not needed as Transactional manages the save
        return userMapper.mapToResponse(user);
    }

    // Delete User
    @Transactional
    public void deleteUser(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User does not exist"));
        userRepository.delete(user);
    }


}
