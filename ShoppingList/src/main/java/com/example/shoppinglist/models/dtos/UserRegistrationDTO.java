package com.example.shoppinglist.models.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationDTO {

    @Size(min = 3, max = 20)
    @NotBlank
    private String username;

    @Email
    @NotBlank
    private String email;

    @Size(min = 3, max = 20)
    @NotBlank
    private String password;

    @Size(min = 3,max = 20)
    private String confirmPassword;

}
