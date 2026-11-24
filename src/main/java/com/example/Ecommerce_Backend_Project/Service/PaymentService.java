package com.example.Ecommerce_Backend_Project.Service;

import com.example.Ecommerce_Backend_Project.Model.Order;
import com.example.Ecommerce_Backend_Project.Model.Payment;
import com.example.Ecommerce_Backend_Project.Repository.OrderItemRepo;
import com.example.Ecommerce_Backend_Project.Repository.OrderRepo;
import com.example.Ecommerce_Backend_Project.Repository.PaymentRepo;
import com.example.Ecommerce_Backend_Project.RequestDTOs.PaymentRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;


@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepo paymentRepo;
    private final OrderRepo orderRepo;

    @Transactional
    public Payment makePayment(PaymentRequestDto paymentRequestDto) {
        Order order=orderRepo.findById(paymentRequestDto.getOrderId()).orElseThrow(() -> new RuntimeException("Order Not Found"));
        Payment payment = Payment.builder()
                .order(order)
                .paymentStatus("Success")
                .paymentDate(LocalDate.now())
                .paymentTime(LocalTime.now())
                .build();
        order.setPayment(payment);
        return paymentRepo.save(payment);
    }
}
