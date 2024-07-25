package com.perfumeOnlineStore.controller.product.command.deleteProductCommand;

import org.springframework.http.HttpStatus;

public record DeleteProductCommandResponse(Long productId, HttpStatus responseStatus) {
}
