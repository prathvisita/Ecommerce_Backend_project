package com.example.Ecommerce_Backend_Project.SprinSecurity;

import com.example.Ecommerce_Backend_Project.Model.Users;
import com.example.Ecommerce_Backend_Project.Repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user=userRepo.findByUsername(username);
        return new UserPrincipal(user);
    }
}
