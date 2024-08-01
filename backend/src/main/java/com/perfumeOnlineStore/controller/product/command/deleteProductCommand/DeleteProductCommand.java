package com.perfumeOnlineStore.controller.product.command.deleteProductCommand;

import an.awesome.pipelinr.Command;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DeleteProductCommand implements Command<DeleteProductCommandResponse> {
    @NotNull(message = "Product ID must be set")
    private Long productId;
}
