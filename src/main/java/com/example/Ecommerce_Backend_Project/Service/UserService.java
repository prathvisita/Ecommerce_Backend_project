package com.example.Ecommerce_Backend_Project.Service;

import com.example.Ecommerce_Backend_Project.Model.Cart;
import com.example.Ecommerce_Backend_Project.RequestDTOs.UserRequestDto;
import com.example.Ecommerce_Backend_Project.Repository.UserRepo;
import lombok.RequiredArgsConstructor;
import com.example.Ecommerce_Backend_Project.Model.Users;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Users registerUser(UserRequestDto userRequestDto){
        Cart cart=new Cart();
        Users user= Users.builder()
                .firstName(userRequestDto.getFirstName())
                .lastName(userRequestDto.getLastName())
                .mobileNumber(userRequestDto.getMobileNumber())
                .email(userRequestDto.getEmail())
                .birthDate(userRequestDto.getBirthDate())
                .username(userRequestDto.getUsername())
                .password(bCryptPasswordEncoder.encode(userRequestDto.getPassword()))
                .cart(cart)
                .build();
        return user;
    }
}
