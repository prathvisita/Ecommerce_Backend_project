package com.example.Ecommerce_Backend_Project.Service;

import com.example.Ecommerce_Backend_Project.Repository.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepo orderRepo;
}
