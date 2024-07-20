package com.perfumeOnlineStore.discount;

import com.perfumeOnlineStore.product.Product;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "numeric", nullable = false)
    private Double percent;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime startedDate;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime endedDate;
    @Column(nullable = false, columnDefinition = "text")
    private String description;
    @ManyToMany(mappedBy = "discounts")
    private List<Product> products = new ArrayList<>();

    public Discount(
            Double percent,
            String name,
            LocalDateTime startedDate,
            LocalDateTime endedDate,
            String description
    ) {
        this.percent = percent;
        this.name = name;
        this.startedDate = startedDate;
        this.endedDate = endedDate;
        this.description = description;
    }
}
