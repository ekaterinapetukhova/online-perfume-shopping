package com.perfumeOnlineStore.controller.product.createProductCommand;

import org.springframework.http.ResponseEntity;

public record CreateProductCommandResponse(Long productId, ResponseEntity<?> responseStatus) {
}
