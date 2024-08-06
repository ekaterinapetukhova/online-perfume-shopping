package com.perfumeOnlineStore.dto;

import com.perfumeOnlineStore.entity.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDto {
    private Long id;
    private Double totalPrice;
    private Order.Status status;
    private LocalDateTime date;
    private User user;
    private List<OrderItem> orderItems;
}
