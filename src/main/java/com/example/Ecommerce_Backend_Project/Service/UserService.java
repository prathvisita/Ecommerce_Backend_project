package com.example.Ecommerce_Backend_Project.Service;

import com.example.Ecommerce_Backend_Project.Model.Cart;
import com.example.Ecommerce_Backend_Project.RequestDTOs.UserLoginDto;
import com.example.Ecommerce_Backend_Project.RequestDTOs.UserRequestDto;
import com.example.Ecommerce_Backend_Project.Repository.UserRepo;
import com.example.Ecommerce_Backend_Project.SprinSecurity.JwtService;
import lombok.RequiredArgsConstructor;
import com.example.Ecommerce_Backend_Project.Model.Users;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public Users registerUser(UserRequestDto userRequestDto) {
        Cart cart = new Cart();
        boolean users = userRepo.existsByname(userRequestDto.getUsername());
        if (users) {
            throw new RuntimeException("user already exists");
        }
            Users user = Users.builder()
                    .firstName(userRequestDto.getFirstName())
                    .lastName(userRequestDto.getLastName())
                    .mobileNumber(userRequestDto.getMobileNumber())
                    .email(userRequestDto.getEmail())
                    .birthDate(userRequestDto.getBirthDate())
                    .username(userRequestDto.getUsername())
                    .password(bCryptPasswordEncoder.encode(userRequestDto.getPassword()))
                    .cart(cart)
                    .build();
            cart.setUser(user);
            userRepo.save(user);

        return user;
    }
    public String login(UserLoginDto userLoginDto){
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userLoginDto.getUsername(), userLoginDto.getPassword()));
        if(authenticate.isAuthenticated()){
            return jwtService.getToken(userLoginDto);
        }
        return "not valid";
    }
}
