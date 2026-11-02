package com.example.Ecommerce_Backend_Project.Service;

import com.example.Ecommerce_Backend_Project.Repository.CartRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepo cartRepo;
}
