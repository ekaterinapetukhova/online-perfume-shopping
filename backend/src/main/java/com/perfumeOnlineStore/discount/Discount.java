package com.perfumeOnlineStore.discount;

import com.perfumeOnlineStore.product.Product;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
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
    private Date startedDate;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date endedDate;
    @Column(nullable = false, columnDefinition = "text")
    private String description;
    @ManyToMany(mappedBy = "discounts")
    private List<Product> products = new ArrayList<>();

    public Discount(
            Double percent,
            String name,
            Date startedDate,
            Date endedDate,
            String description
    ) {
        this.percent = percent;
        this.name = name;
        this.startedDate = startedDate;
        this.endedDate = endedDate;
        this.description = description;
    }
}
