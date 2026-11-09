package com.example.Ecommerce_Backend_Project.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Cart")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String customerName;

    private String customerEmail;

    private String customerPhone;

    private String customerAddress;

    private String customerCity;

    private String customerState;

    private String customerPinCode;

    private String customerCountry;

    @OneToOne(mappedBy = "cart",cascade = CascadeType.ALL)
    private User user;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name="Cart_Product",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    @Builder.Default
    @JsonIgnoreProperties("Orders")
    private List<Product> products=new ArrayList<>();

}
