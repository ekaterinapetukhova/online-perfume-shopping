package com.perfumeOnlineStore.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "text")
    private String description;
    private String brand;
    @Column(columnDefinition = "numeric")
    private Double price;
    @Column(columnDefinition = "text")
    private String components;
    @Column(columnDefinition = "text")
    private String scentGroups;
    private Integer quantity;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Integer volume;

    public enum Gender {
        MALE, FEMALE
    }

    public Product(String name,
                   String description,
                   String brand,
                   Double price,
                   String components,
                   String scentGroups,
                   Integer quantity,
                   Gender gender,
                   Integer volume) {
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.price = price;
        this.components = components;
        this.scentGroups = scentGroups;
        this.quantity = quantity;
        this.gender = gender;
        this.volume = volume;
    }
}
