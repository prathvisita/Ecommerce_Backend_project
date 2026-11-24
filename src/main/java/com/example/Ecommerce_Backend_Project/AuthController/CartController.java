package com.example.Ecommerce_Backend_Project.AuthController;

import com.example.Ecommerce_Backend_Project.Model.Cart;
import com.example.Ecommerce_Backend_Project.Model.CartItem;
import com.example.Ecommerce_Backend_Project.Service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping("/cartitems/userid/{userid}")
    public ResponseEntity<List<CartItem>> getCart(@PathVariable Long userid){
        return ResponseEntity.ok(cartService.getCart(userid));
    }

    @PostMapping("/userid/{userid}/productid/{productid}")
    public ResponseEntity<CartItem> addCartItem(@PathVariable Long userid,@PathVariable Long productid){
        return ResponseEntity.status(HttpStatus.CREATED).body(cartService.addCartItem(userid,productid));
    }

    @DeleteMapping("/userid/{userid}/productid/{productid}")
    public ResponseEntity<?> deleteCartItem(@PathVariable Long userid,@PathVariable Long productid){
        cartService.removeCartItem(userid,productid);
       return ResponseEntity.noContent().build();
    }

}
