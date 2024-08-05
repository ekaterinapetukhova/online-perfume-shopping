package com.perfumeOnlineStore.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Table
@Entity
@Data
@NoArgsConstructor
@JsonIgnoreProperties(value = { "hibernateLazyInitializer" })
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(columnDefinition = "text", nullable = false)
    private String description;
    @JsonManagedReference
    @OneToMany(
            mappedBy = "category",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Product> products;

    public Category(
            String name,
            String description
    ) {
        this.name = name;
        this.description = description;
    }
}
