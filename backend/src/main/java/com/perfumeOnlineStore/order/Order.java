package com.perfumeOnlineStore.order;

import com.perfumeOnlineStore.orderItem.OrderItem;
import com.perfumeOnlineStore.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, columnDefinition = "numeric")
    private Double totalPrice;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();

    public enum Status {
        ORDER_PLACED,
        ORDER_PENDING_PAYMENT,
        ORDER_PAID,
        ORDER_CONFIRMED,
        ORDER_FULFILLED,
        ORDER_CANCELLED,
    }

    public Order(
            Double totalPrice,
            Status status,
            LocalDateTime date
    ) {
        this.totalPrice = totalPrice;
        this.status = status;
        this.date = date;
    }

}
