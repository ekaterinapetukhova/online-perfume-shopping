package com.perfumeOnlineStore.controller.orderItem.query.getOrderItemByIdQuery;

import an.awesome.pipelinr.Command;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class GetOrderItemByIdQuery implements Command<GetOrderItemByIdQueryResponse> {
    private UUID id;
}
