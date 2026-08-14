package com.system.smartParking.user.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private String email;
    private String phone;
    private Role role = Role.ROLE_USER;
}
