package com.perfumeOnlineStore.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startedDate;
    @Column(nullable = false)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endedDate;
    @Column(nullable = false, columnDefinition = "text")
    private String description;
    @ManyToMany(mappedBy = "discounts")
    @JsonIgnoreProperties(value = { "discounts" })
    private List<Product> products;

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
