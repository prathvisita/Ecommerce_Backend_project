package com.example.Ecommerce_Backend_Project.RequestDTOs;

import lombok.Data;

@Data
public class ProductRequestDto {
    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    private String category;
}
