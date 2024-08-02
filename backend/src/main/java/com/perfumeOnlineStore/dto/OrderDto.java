package com.perfumeOnlineStore.dto;

import com.perfumeOnlineStore.entity.Order;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderDto {
    private Long id;
    private Double totalPrice;
    private Order.Status status;
    private LocalDateTime date;
}
