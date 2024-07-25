package com.perfumeOnlineStore.controller.product.command.deleteProductCommand;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeleteProductCommand {
    private Long productId;
}
