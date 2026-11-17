package com.example.Ecommerce_Backend_Project.Service;

import com.example.Ecommerce_Backend_Project.RequestDTOs.ProductRequestDto;
import com.example.Ecommerce_Backend_Project.Model.Product;
import com.example.Ecommerce_Backend_Project.Repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public void delete(Long id){
        Product product =productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product with id"+id+"not found"   ));
        productRepo.delete(product);
    }

    public Product updateProduct(ProductRequestDto productRequestDto,String name){
        Product product=findproduct(name);
        product.setName(productRequestDto.getName());
        product.setDescription(productRequestDto.getDescription());
        product.setPrice(productRequestDto.getPrice());
        product.setImageUrl(productRequestDto.getImageUrl());
        product.setCategory(productRequestDto.getCategory());
        productRepo.save(product);
        return product;
    }

    public Product findproduct(String name){
        return productRepo.findByName(name);
    }
}
