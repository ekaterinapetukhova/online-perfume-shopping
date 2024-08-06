package com.perfumeOnlineStore.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Table
@Entity
@Data
@NoArgsConstructor
@JsonIgnoreProperties(value = { "hibernateLazyInitializer" })
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(columnDefinition = "text", nullable = false)
    private String description;
    @Column(nullable = false)
    private String brand;
    @Column(columnDefinition = "numeric", nullable = false)
    private Double price;
    @Column(columnDefinition = "text", nullable = false)
    private String components;
    @Column(columnDefinition = "text", nullable = false)
    private String scentGroups;
    @Column(nullable = false)
    private Integer quantity;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;
    @Column(nullable = false)
    private Integer volume;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    @JsonBackReference
    private Category category;

    @ManyToMany
    @JoinTable(
            name = "product_discount",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "discount_id"))
    private Set<Discount> discounts = new HashSet<>();

    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private Set<OrderItem> orderItems = new HashSet<>();

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
