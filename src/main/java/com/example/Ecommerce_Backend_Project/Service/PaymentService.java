package com.example.Ecommerce_Backend_Project.Service;

import com.example.Ecommerce_Backend_Project.Repository.PaymentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepo paymentRepo;
}
