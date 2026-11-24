package com.example.Ecommerce_Backend_Project.AuthController;

import com.example.Ecommerce_Backend_Project.RequestDTOs.UserLoginDto;
import com.example.Ecommerce_Backend_Project.RequestDTOs.UserRequestDto;
import com.example.Ecommerce_Backend_Project.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<?>  register(@RequestBody UserRequestDto userRequestDto){
        return ResponseEntity.ok(userService.registerUser(userRequestDto));
    }

    @PostMapping
    public String Login(@RequestBody UserLoginDto userLoginDto){
        return userService.login(userLoginDto);
    }
}
