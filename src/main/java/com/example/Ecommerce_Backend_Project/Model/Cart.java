package com.example.Ecommerce_Backend_Project.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Cart")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String customerName;

    private String customerEmail;

    private String customerPhone;

    private String customerAddress;

    private String customerCity;

    private String customerState;

    private String customerCountryName;

    private String customerPinCode;

    private String customerCountry;



}
