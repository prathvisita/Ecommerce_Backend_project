package com.example.Ecommerce_Backend_Project.AuthController;

import com.example.Ecommerce_Backend_Project.Service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;
}
