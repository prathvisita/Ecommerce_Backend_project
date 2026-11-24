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
    public CartItem addCartItem(Long userid,Long productid){
        Users user=userRepo.findById(userid).orElseThrow(() -> new NullPointerException("User Not Found"));
        Product product=productRepo.findById(productid).orElseThrow(() -> new NullPointerException("Product Not Found"));
        Cart cart=user.getCart();
;
        CartItem cartItemExists=cart.getCartItemList().stream().filter(cartItem->cartItem.getProduct().getId()==product.getId())
                .findFirst().orElse(null);
        if(cartItemExists!=null){
          cartItemExists.setQuantity(cartItemExists.getQuantity()+1);
          throw new IllegalStateException("Cart Item Already Exists");
        }
            CartItem cartItem = CartItem.builder()
                    .product(product)
                    .cart(cart)
                    .quantity(1)
                    .build();
            cart.getCartItemList().add(cartItem);
            cartRepo.save(cart);

            return cartItem;
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
                if(isExists.getQuantity()>1) {
                    isExists.setQuantity(isExists.getQuantity() - 1);
                    cartItemRepo.save(isExists);
                }else {
                    cart.getCartItemList().remove(isExists);
                    cartItemRepo.delete(isExists);
                }

            }
           // return cart;
        }


}
