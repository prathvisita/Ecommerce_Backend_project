package com.example.Ecommerce_Backend_Project.AuthController;

import com.example.Ecommerce_Backend_Project.Model.Order;
import com.example.Ecommerce_Backend_Project.Model.OrderItem;
import com.example.Ecommerce_Backend_Project.RequestDTOs.AdressRequestDto;
import com.example.Ecommerce_Backend_Project.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class OrderController {
        private final OrderService orderService;

        @GetMapping("/orders/userid/{userid}")
        public ResponseEntity<List<Order>>getAllOrderItem(@PathVariable("userid") Long id){
                return  ResponseEntity.ok(orderService.getAllOrders(id));
        }

        @PostMapping("/order/userid/{userid}/productid/{productid}")
        public ResponseEntity<Order>addOrderItem(@PathVariable Long userid, @PathVariable Long productid, @RequestBody AdressRequestDto adressRequestDto){
                return ResponseEntity.status(HttpStatus.CREATED).body(orderService.addOrder(userid,adressRequestDto,productid));
        }

        @DeleteMapping("/order/userid/{userid}/productid/{productid}")
        public ResponseEntity<?>deleteOrderItem(@PathVariable Long userid, @PathVariable Long productid){
                orderService.cancelOrder(userid,productid);
                return ResponseEntity.noContent().build();
        }
}
