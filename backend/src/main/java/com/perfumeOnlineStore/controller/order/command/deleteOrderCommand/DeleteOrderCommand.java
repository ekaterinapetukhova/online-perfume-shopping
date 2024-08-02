package com.perfumeOnlineStore.controller.order.command.deleteOrderCommand;

import an.awesome.pipelinr.Command;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
public class DeleteOrderCommand implements Command<DeleteOrderCommandResponse> {
    @NotNull(message = "Order's ID must be set")
    private Long id;
}
