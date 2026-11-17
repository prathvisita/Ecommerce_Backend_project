package com.example.Ecommerce_Backend_Project.RequestDTOs;

import lombok.Data;

@Data
public class UserRequestDto {
    private String firstName;
    private String lastName;

    private String mobileNumber;
    private String email;

    private String birthDate;

    private String username;
    private String password;
}
