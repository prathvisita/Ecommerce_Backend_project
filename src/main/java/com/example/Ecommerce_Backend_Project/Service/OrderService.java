package com.example.Ecommerce_Backend_Project.Service;

import com.example.Ecommerce_Backend_Project.Model.*;
import com.example.Ecommerce_Backend_Project.Repository.UserAdressRepository;
import com.example.Ecommerce_Backend_Project.Repository.OrderItemRepo;
import com.example.Ecommerce_Backend_Project.Repository.OrderRepo;
import com.example.Ecommerce_Backend_Project.Repository.ProductRepo;
import com.example.Ecommerce_Backend_Project.Repository.UserRepo;
//import jakarta.transaction.Transactional;
import com.example.Ecommerce_Backend_Project.RequestDTOs.AdressRequestDto;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepo orderRepo;
    private final UserRepo userRepo;
    private final ProductRepo productRepo;
    private final OrderItemRepo orderItemRepo;
    private final UserAdressRepository userAdressRepository;

    @Transactional(readOnly=true)
    public List<Order> getAllOrders(Long id){
        Users user=userRepo.findById(id).orElseThrow(() -> new NullPointerException("user with id"+id+"not found"));
        return user.getOrders();
    }

    @Transactional
    public Order addOrder(Long productid, AdressRequestDto adressRequestDto,Long id){
        Users user=userRepo.findById(id).orElseThrow(() -> new NullPointerException("user with id"+id+"not found"));
        Product product=productRepo.findById(productid).orElseThrow(() -> new NullPointerException("product with id"+productid+"not found"));
        UserAdress userAdress=UserAdress.builder()
                .street(adressRequestDto.getStreet())
                .city(adressRequestDto.getCity())
                .state(adressRequestDto.getState())
                .zip(adressRequestDto.getZip())
                .country(adressRequestDto.getCountry())
                .user(user)
                .build();
        userAdressRepository.save(userAdress);

        Order order= Order.builder()
                .orderDate(LocalDateTime.now())
                .orderType("B2B")
                .userAdress(userAdress)
                .user(user)
                .build();
        orderRepo.save(order);

        OrderItem orderItem=OrderItem.builder()
                        .order(order)
                        .price(10000)
                        .quantity(1)
                        .product(product)
                        .build();
        orderItemRepo.save(orderItem);

        user.getOrders().add(order);
        user.getUserAdress().add(userAdress);
        userAdress.getOrder().add(order);
        order.getOrderItems().add(orderItem);
        return order;
    }

    @Transactional
    public Order cancelOrder(Long id){
        Order order=orderRepo.findById(id).orElseThrow(() -> new NullPointerException("order with id"+id+"not found"));
        orderRepo.delete(order);
        return order;
    }
}
