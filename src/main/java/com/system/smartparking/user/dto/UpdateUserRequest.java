package com.system.smartparking.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateUserRequest {

    private String name;

    @Pattern(regexp = "\\d{10}", message = "Phone must contain exactly 10 digits") // regex to validate only numbers of 10 digits
    private String phone;
}
