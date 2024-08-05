package com.perfumeOnlineStore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Table
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(columnDefinition = "text", nullable = false)
    private String description;
    @JsonIgnore
    @JsonIgnoreProperties({ "hibernateLazyInitializer" })
    @OneToMany(
            mappedBy = "category",
            cascade = CascadeType.MERGE,
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
