package com.example.Ecommerce_Backend_Project.Repository;

import com.example.Ecommerce_Backend_Project.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users,Long> {

    boolean existsByname(String username);
    Users findByUsername(String username);
    boolean existsByemail(String email);
    boolean existsByusername(String username);
}
