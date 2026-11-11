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

    @Column(unique = false,nullable = false)
    private String customerName;

    @Column(unique = false,nullable = false)
    private String customerEmail;

    @Column(unique =true,nullable = false)
    private String customerPhone;

    @Column(unique = false,nullable = false)
    private String customerAddress;

    @Column(unique = false,nullable = false)
    private String customerCity;

    @Column(unique = false,nullable = false)
    private String customerState;

    @Column(unique = false,nullable = false)
    private String customerPinCode;

    @Column(unique = false,nullable = false)
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
