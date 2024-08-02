package com.perfumeOnlineStore.controller.order.command.createOrderCommand;

import an.awesome.pipelinr.Command;
import com.perfumeOnlineStore.entity.Order;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateOrderCommand implements Command<CreateOrderCommandResponse> {
    @NotNull(message = "Order's total price must be set")
    @Min(value = 0, message = "Order's total price can't be less than zero")
    private Double totalPrice;
    @NotNull(message = "Order's status must be set")
    private Order.Status status;
    @NotNull(message = "Order's date must be set")
    private LocalDateTime date;
}
