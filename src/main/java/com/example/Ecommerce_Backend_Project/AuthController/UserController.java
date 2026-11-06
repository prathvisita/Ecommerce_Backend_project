package com.example.Ecommerce_Backend_Project.AuthController;

import com.example.Ecommerce_Backend_Project.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
}
