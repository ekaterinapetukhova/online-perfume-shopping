package com.perfumeOnlineStore.controller.product.query.getProductByIdQuery;

import an.awesome.pipelinr.Command;
import com.perfumeOnlineStore.dto.ProductDto;
import com.perfumeOnlineStore.entity.Product;
import com.perfumeOnlineStore.mapper.product.ProductToDtoMapper;
import com.perfumeOnlineStore.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetProductByIdQueryHandler implements Command.Handler<GetProductByIdQuery, GetProductByIdQueryResponse>{
    private final ProductService productService;

    public GetProductByIdQueryResponse handle(GetProductByIdQuery query) {
        GetProductByIdQueryResponse resp = new GetProductByIdQueryResponse();

        try {
            Optional<Product> product = productService.findProductById(query.getId());

            if (product.isPresent()) {
                ProductDto productDto = product.map(ProductToDtoMapper.INSTANCE::toDto).get();

                resp.setSuccess(true);
                resp.setStatusCode(HttpStatus.OK.value());
                resp.setStatus(HttpStatus.OK.name());
                resp.setPayload(productDto);
            } else {
                resp.setStatusCode(HttpStatus.NOT_FOUND.value());
                resp.setStatus(HttpStatus.NOT_FOUND.name());
                resp.setPayload(null);
            }

            return resp;
        } catch (Exception e) {
            return resp;
        }
    }
}
