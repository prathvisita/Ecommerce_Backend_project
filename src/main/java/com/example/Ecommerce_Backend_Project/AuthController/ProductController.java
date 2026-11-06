package com.example.Ecommerce_Backend_Project.AuthController;

import com.example.Ecommerce_Backend_Project.DTO.ProductRequestDto;
import com.example.Ecommerce_Backend_Project.Model.Product;
import com.example.Ecommerce_Backend_Project.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(productService.findAll());
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody ProductRequestDto productRequestDto){
    return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(productRequestDto));
    }
}
