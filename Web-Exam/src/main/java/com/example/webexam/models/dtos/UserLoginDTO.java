package com.example.webexam.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginDTO {

    @Size(min = 3, max = 20, message = "username length must be between 3 and 20 characters.")
    @NotBlank
    private String username;

    @Size(min = 3, max = 20,  message = "password length must be between 3 and 20 characters.")
    @NotBlank
    private String password;
}
