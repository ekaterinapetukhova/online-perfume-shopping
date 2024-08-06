package com.perfumeOnlineStore.controller.order.query.getOrderByIdQuery;

import an.awesome.pipelinr.Command;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class GetOrderByIdQuery implements Command<GetOrderByIdQueryResponse> {
    private Long id;
}
