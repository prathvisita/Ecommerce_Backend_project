package com.example.Ecommerce_Backend_Project.Service;

import com.example.Ecommerce_Backend_Project.Model.Cart;

import com.example.Ecommerce_Backend_Project.Model.CartItem;
import com.example.Ecommerce_Backend_Project.Model.Product;
import com.example.Ecommerce_Backend_Project.Repository.CartItemRepo;
import com.example.Ecommerce_Backend_Project.Repository.CartRepo;
import com.example.Ecommerce_Backend_Project.Model.Users;
import com.example.Ecommerce_Backend_Project.Repository.ProductRepo;
import com.example.Ecommerce_Backend_Project.Repository.UserRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepo cartRepo;
    private final CartItemRepo cartItemRepo;
    private final UserRepo userRepo;
    private final ProductRepo productRepo;


    @Transactional
    public List<CartItem> getCart(Long id){
       Users user=userRepo.findById(id).orElseThrow(() -> new NullPointerException("User Not Found"));
          Cart cart=user.getCart();
          return cart.getCartItemList();
    }

    @Transactional
    public Cart addCartItem(Long userid,Long productid){
        Users user=userRepo.findById(userid).orElseThrow(() -> new NullPointerException("User Not Found"));
        Product product=productRepo.findById(productid).orElseThrow(() -> new NullPointerException("Product Not Found"));
        Cart cart=user.getCart();
;
        boolean cartItemExists=cart.getCartItemList().stream().anyMatch(cartItem->cartItem.getProduct().getId()==product.getId());
        if(cartItemExists==true){
            throw new IllegalStateException("Cart Item Already Exists");
        }
            CartItem cartItem = CartItem.builder()
                    .product(product)
                    .cart(cart)
                    .quantity(1)
                    .build();

            cart.getCartItemList().add(cartItem);
            cartRepo.save(cart);

            return cart;
        }

        @Transactional
        public void removeCartItem(Long userid,Long productid){
            Users user=userRepo.findById(userid).orElseThrow(() -> new NullPointerException("User Not Found"));
            Product product=productRepo.findById(productid).orElseThrow(() -> new NullPointerException("Product Not Found"));
            Cart cart=user.getCart();
            CartItem isExists=cart.getCartItemList().stream()
                    .filter(item -> item.getProduct().getId().equals(productid))
                    .findFirst()
                    .orElse(null);
            if(isExists!=null){
                isExists.setQuantity(isExists.getQuantity()+1);
                cartItemRepo.delete(isExists);
                cart.getCartItemList().remove(isExists);
            }
           // return cart;
        }


}
