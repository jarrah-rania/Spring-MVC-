package com.example.mvc.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class Product {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private  double price;
    private int quantity;

}
