package com.perfumeOnlineStore.controller.orderItem.command.deleteOrderItemCommand;

import an.awesome.pipelinr.Command;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class DeleteOrderItemCommand implements Command<DeleteOrderItemCommandResponse> {
    @NotNull(message = "Order item's ID must be set")
    private UUID id;
}
