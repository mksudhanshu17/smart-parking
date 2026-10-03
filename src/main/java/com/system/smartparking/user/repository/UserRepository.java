package com.system.smartparking.user.repository;

import com.system.smartparking.user.entity.Role;
import com.system.smartparking.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
         Optional<User> findByEmail(String email);

         boolean existsByEmail(String email);

         boolean existsByPhone(String phone);

         List<User> findAllByRole(Role role);
}
