package com.perfumeOnlineStore.controller.product.query.getProductByIdQuery;

import an.awesome.pipelinr.Command;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class GetProductByIdQuery implements Command<GetProductByIdQueryResponse> {
    private UUID id;
}
