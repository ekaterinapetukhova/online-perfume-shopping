package com.perfumeOnlineStore.controller.product.command.updateProductCommand;

import org.springframework.http.HttpStatus;

public record UpdateProductCommandResponse(Long productId, HttpStatus responseStatus) {
}
