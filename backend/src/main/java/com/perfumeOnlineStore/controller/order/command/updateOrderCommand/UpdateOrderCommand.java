package com.perfumeOnlineStore.controller.order.command.updateOrderCommand;

import an.awesome.pipelinr.Command;
import com.perfumeOnlineStore.entity.Order;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
public class UpdateOrderCommand implements Command<UpdateOrderCommandResponse> {
    @NotNull(message = "Order's ID must be set")
    private Long id;
    @NotNull(message = "Order's total price must be set")
    @Min(value = 0, message = "Order's total price can't be less than zero")
    private Double totalPrice;
    @NotNull(message = "Order's status must be set")
    private Order.Status status;
    @NotNull(message = "Order's date must be set")
    private LocalDateTime date;
}
