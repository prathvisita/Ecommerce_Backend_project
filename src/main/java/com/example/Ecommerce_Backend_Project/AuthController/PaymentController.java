package com.example.Ecommerce_Backend_Project.AuthController;

import com.example.Ecommerce_Backend_Project.Model.Payment;
import com.example.Ecommerce_Backend_Project.RequestDTOs.PaymentRequestDto;
import com.example.Ecommerce_Backend_Project.Service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping
    public Payment makePayment(@RequestBody PaymentRequestDto paymentRequestDto) {
        return paymentService.makePayment(paymentRequestDto);
    }
}
