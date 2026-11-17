package com.example.Ecommerce_Backend_Project.AuthController;

import com.example.Ecommerce_Backend_Project.RequestDTOs.ProductRequestDto;
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

    @GetMapping("/products")
    public ResponseEntity<Product>findproduct(@RequestParam String name){
        return ResponseEntity.ok(productService.findproduct(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.delete(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/{name}")
    public ResponseEntity<Product> updateProduct(@PathVariable String name, @RequestBody ProductRequestDto productRequestDto){
        return ResponseEntity.ok(productService.updateProduct(productRequestDto,name));
    }
}
