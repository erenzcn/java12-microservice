package org.example.basket.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BasketProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int count;
    private double totalPrice;

    private int productId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "basket_id")
    private Basket basket;

}
