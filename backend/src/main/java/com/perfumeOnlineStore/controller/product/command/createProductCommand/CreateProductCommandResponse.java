package com.perfumeOnlineStore.controller.product.command.createProductCommand;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public record CreateProductCommandResponse(Long productId, HttpStatus responseStatus) {
}
