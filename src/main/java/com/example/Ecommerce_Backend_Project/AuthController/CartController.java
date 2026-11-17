package com.example.Ecommerce_Backend_Project.AuthController;

import com.example.Ecommerce_Backend_Project.Model.Cart;
import com.example.Ecommerce_Backend_Project.Model.CartItem;
import com.example.Ecommerce_Backend_Project.Service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
    private final CartItemService cartItemService;

   public List<CartItem> getCartItems(){
       return cartItemService.getCartItemList();
   }

   public Cart addCartItem(CartItem cartItem){

   }
}
