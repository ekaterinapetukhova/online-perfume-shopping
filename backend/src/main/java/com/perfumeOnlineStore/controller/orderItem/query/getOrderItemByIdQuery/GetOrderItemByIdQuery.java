package com.perfumeOnlineStore.controller.orderItem.query.getOrderItemByIdQuery;

import an.awesome.pipelinr.Command;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class GetOrderItemByIdQuery implements Command<GetOrderItemByIdQueryResponse> {
    private Long id;
}
