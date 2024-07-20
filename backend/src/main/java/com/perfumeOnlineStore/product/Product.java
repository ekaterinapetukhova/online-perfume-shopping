package com.perfumeOnlineStore.product;

import com.perfumeOnlineStore.category.Category;
import com.perfumeOnlineStore.discount.Discount;
import com.perfumeOnlineStore.orderItem.OrderItem;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany
    @JoinTable(
            name = "product_discount",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "discount_id"))
    private List<Discount> discounts = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderItem_id")
    private OrderItem orderItem;

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
                   Integer volume,
                   Category category) {
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.price = price;
        this.components = components;
        this.scentGroups = scentGroups;
        this.quantity = quantity;
        this.gender = gender;
        this.volume = volume;
        this.category = category;
    }
}
