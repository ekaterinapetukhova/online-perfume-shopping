package com.perfumeOnlineStore.controller.orderItem.command.updateOrderItemCommand;

import an.awesome.pipelinr.Command;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
public class UpdateOrderItemCommand implements Command<UpdateOrderItemCommandResponse> {
    @NotNull(message = "Order item's ID must be set")
    private UUID id;
    @NotNull(message = "Order item's quantity must be set")
    @Min(value = 0, message = "Order item's quantity can't be negative number")
    private Integer quantity;
    @NotNull(message = "Order item's price must be set")
    @Min(value = 1, message = "Order item's price can't be less than zero")
    private Double price;
}
