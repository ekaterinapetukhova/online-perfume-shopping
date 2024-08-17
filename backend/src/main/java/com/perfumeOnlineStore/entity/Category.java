package com.perfumeOnlineStore.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Table
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    private Set<Product> products = new HashSet<>();

    public Category(
            String name,
            String description
    ) {
        this.name = name;
        this.description = description;
    }
}
