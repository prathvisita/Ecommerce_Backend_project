package com.example.Ecommerce_Backend_Project.Service;

import com.example.Ecommerce_Backend_Project.DTO.ProductRequestDto;
import com.example.Ecommerce_Backend_Project.Model.Product;
import com.example.Ecommerce_Backend_Project.Repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;

    public List<Product> findAll(){
        return productRepo.findAll();
    }

    public Product addProduct(ProductRequestDto productRequestDto){
        Product product = Product.builder()
                .name(productRequestDto.getName())
                .description(productRequestDto.getDescription())
                .price(productRequestDto.getPrice())
                .imageUrl(productRequestDto.getImageUrl())
                .category(productRequestDto.getCategory())
                .build();
        return productRepo.save(product);
    }
}
