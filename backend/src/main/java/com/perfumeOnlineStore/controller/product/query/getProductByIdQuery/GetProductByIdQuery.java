package com.perfumeOnlineStore.controller.product.query.getProductByIdQuery;

import an.awesome.pipelinr.Command;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class GetProductByIdQuery implements Command<GetProductByIdQueryResponse> {
    private Long id;
}
