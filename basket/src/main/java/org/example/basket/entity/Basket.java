package org.example.basket.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int status;
    private Double totalPrice;
    private int userId;
    @OneToMany(mappedBy = "basket", cascade = CascadeType.ALL)
    private List<BasketProduct> basketProducts;

}
