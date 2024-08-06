package com.perfumeOnlineStore.controller.product.command.deleteProductCommand;

import an.awesome.pipelinr.Command;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class DeleteProductCommand implements Command<DeleteProductCommandResponse> {
    @NotNull(message = "Product ID must be set")
    private UUID id;
}
