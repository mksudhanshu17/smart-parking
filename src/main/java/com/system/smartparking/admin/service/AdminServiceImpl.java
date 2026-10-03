package com.system.smartparking.admin.service;

import com.system.smartparking.exception.ResourceAlreadyExistsException;
import com.system.smartparking.exception.ResourceNotFoundException;
import com.system.smartparking.user.dto.RegisterUserRequest;
import com.system.smartparking.user.dto.UserResponse;
import com.system.smartparking.user.entity.Role;
import com.system.smartparking.user.entity.User;
import com.system.smartparking.user.entity.UserStatus;
import com.system.smartparking.user.mapper.UserMapper;
import com.system.smartparking.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    // CREATE MANAGER

    @Transactional
    public UserResponse createManager (RegisterUserRequest request){
        if (userRepository.existsByEmail(request.getEmail())){
            throw new ResourceAlreadyExistsException("Email already exists!");
        }
        if (userRepository.existsByPhone(request.getPhone())) {
            throw new ResourceAlreadyExistsException("Phone already exists!");
        }
        User user = userMapper.mapToUser(request);
        user.setRole(Role.MANAGER);
        userRepository.save(user);

        return userMapper.mapToResponse(user);
    }
    // DEACTIVATE USER

    @Transactional
    public void deactivateUser (Long id){
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User not found!"));
        if(user.getRole() != Role.USER){
            throw new IllegalArgumentException("Cannot deactivate a user with a higher role");
        }
        user.setStatus(UserStatus.INACTIVE);
    }

    // ACTIVATE USER
    @Transactional
    public void activateUser (Long id){
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User not found!"));
        user.setStatus(UserStatus.ACTIVE);
    }

    // DEACTIVATE MANAGER

    @Transactional
    public void deactivateManager(Long id){
        User user = userRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Manager not found!")
        );
        if(user.getRole() != Role.MANAGER){
            throw new IllegalArgumentException("User is not a manager");
        }

        user.setStatus(UserStatus.INACTIVE);
    }

    // ACTIVATE MANAGER

    @Transactional
    public void activateManager(Long id){
        User user = userRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Manager not found!")
        );
        if(user.getRole() != Role.MANAGER){
            throw new IllegalArgumentException("User is not a manager");
        }

        user.setStatus(UserStatus.ACTIVE);
    }

    // BLOCK USER

    @Transactional
    public void blockUser (Long id){
        User user = userRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("User not found!")
        );
        user.setStatus(UserStatus.BLOCKED);
    }

    // BLOCK MANAGER

    @Transactional
    public void blockManager(Long id){
        User user = userRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Manager not found!")
        );
        if(user.getRole() != Role.MANAGER){
            throw new IllegalArgumentException("User is not a manager");
        }

        user.setStatus(UserStatus.BLOCKED);
    }

    // GET ALL MANAGERS

    public List<UserResponse> getAllManagers (){
        List<User> managers = userRepository.findAllByRole(Role.MANAGER);
        List<UserResponse> response = new ArrayList<>();

        for(User manager : managers){
            response.add(userMapper.mapToResponse(manager));
        }

        return response;
    }
}
