package com.example.userservice.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestUser {

    @NotNull(message = "Email connot be null")
    @Size(min = 2, message = "Email not  be less than two characters.")
    @Email
    private String email;


    @NotNull(message = "Name connot be null")
    @Size(min = 2, message = "Name not  be less than two characters.")
    private String name;


    @NotNull(message = "Password connot be null")
    @Size(min = 8, message = "Passwrod must be equal or greater than 8 characters.")
    private String password;

}
