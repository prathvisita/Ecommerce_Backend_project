package com.example.Ecommerce_Backend_Project.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    private String mobileNumber;
    private String email;

    private String birthDate;

    private String username;
    private String password;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id",unique = true)
    private Cart cart;

    @OneToMany(mappedBy ="user",cascade = CascadeType.ALL)
    @JsonIgnoreProperties("user")
    @Builder.Default
    private List<Order> orders=new ArrayList<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonIgnoreProperties("user")
    private List<UserAdress> userAdress=new ArrayList<>();
}
