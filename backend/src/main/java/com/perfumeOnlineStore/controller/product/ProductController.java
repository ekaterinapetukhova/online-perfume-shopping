package com.perfumeOnlineStore.controller.product;

import an.awesome.pipelinr.Pipeline;
import com.perfumeOnlineStore.controller.product.command.createProductCommand.*;
import com.perfumeOnlineStore.controller.product.command.deleteProductCommand.*;
import com.perfumeOnlineStore.controller.product.command.updateProductCommand.*;
import com.perfumeOnlineStore.controller.product.query.getAllProductsQuery.*;
import com.perfumeOnlineStore.controller.product.query.getProductByIdQuery.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final Pipeline pipeline;

    @GetMapping
    public GetAllProductsQueryResponse getAllProducts() {
        GetAllProductsQuery query = new GetAllProductsQuery();

        return query.execute(pipeline);
    }

    @GetMapping("/{productId}")
    public GetProductByIdQueryResponse getProductById(@PathVariable("productId") UUID id) {
        GetProductByIdQuery query = new GetProductByIdQuery(id);

        return query.execute(pipeline);
    }

    @GetMapping("/add-to-cart/{productId}")
    public ResponseEntity<?> addToCart(@PathVariable("productId") UUID productId,
                                       HttpServletResponse response) {
        Cookie browserSessionCookie = new Cookie(productId.toString(), Long.toString(1L));
        response.addCookie(browserSessionCookie);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/cart")
    public ResponseEntity<?> getCart(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        return ResponseEntity.ok().body(cookies);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public CreateProductCommandResponse createProduct(@RequestBody CreateProductCommand createCommand) {
        return createCommand.execute(pipeline);
    }

    @DeleteMapping("/{productId}")
    public DeleteProductCommandResponse deleteProduct(@PathVariable("productId") UUID id) {
        DeleteProductCommand deleteCommand = new DeleteProductCommand(id);

        return deleteCommand.execute(pipeline);
    }

    @PutMapping(
            value = "/{productId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public UpdateProductCommandResponse updateProductById(@PathVariable("productId") UUID id,
                                                          @RequestBody UpdateProductCommand updateCommand) {
        updateCommand.setId(id);
        return updateCommand.execute(pipeline);
    }
}
