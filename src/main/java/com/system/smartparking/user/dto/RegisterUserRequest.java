package com.system.smartparking.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class RegisterUserRequest {
   @NotBlank
   private String name;

   @NotBlank
   @Size(min = 8, max = 25)
   private String password;

   @NotBlank
   @Email
   private String email;

   @NotBlank
   private String phone;
}
