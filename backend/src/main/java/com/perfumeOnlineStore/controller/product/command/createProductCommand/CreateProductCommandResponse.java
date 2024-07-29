package com.perfumeOnlineStore.controller.product.command.createProductCommand;

import org.springframework.http.HttpStatus;

public record CreateProductCommandResponse(Long productId, int statusCode) {
}
