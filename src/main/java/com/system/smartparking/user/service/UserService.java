package com.system.smartparking.user.service;

import com.system.smartparking.user.entity.User;
import com.system.smartparking.user.exception.UserAlreadyExistsException;
import com.system.smartparking.user.exception.UserNotFoundException;
import com.system.smartparking.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    // Create User
    public User createUser(User user){
        if(userRepository.existsById(user.getId())){
            throw new UserAlreadyExistsException("User already exists");
        }
       return userRepository.save(user);
    }

    // Find User by User ID
    public User getById(Long id){
        Optional<User> op = userRepository.findById(id);
        if (op.isEmpty()){
            throw new UserNotFoundException("User not found");
        }
        return op.get();
    }

    // Find User by email ID;
    public User getByEmail(String email){
        Optional<User> op = userRepository.getByEmail(email);
    }
}
