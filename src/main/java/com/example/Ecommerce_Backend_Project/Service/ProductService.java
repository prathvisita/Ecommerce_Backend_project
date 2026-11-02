package com.example.Ecommerce_Backend_Project.Service;

import com.example.Ecommerce_Backend_Project.Repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;
}
