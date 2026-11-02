package com.example.Ecommerce_Backend_Project.Repository;

import com.example.Ecommerce_Backend_Project.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
}
