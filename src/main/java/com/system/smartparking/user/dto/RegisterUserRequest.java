package com.system.smartparking.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegisterUserRequest {
   private String name;
   private String password;
    private String email;
    private String phone;
}
