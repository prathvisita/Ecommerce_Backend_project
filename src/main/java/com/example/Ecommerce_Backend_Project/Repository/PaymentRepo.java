package com.example.Ecommerce_Backend_Project.Repository;

import com.example.Ecommerce_Backend_Project.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo extends JpaRepository<Payment,Long> {
}
