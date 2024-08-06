package com.perfumeOnlineStore.controller.order.query.getOrderByIdQuery;

import an.awesome.pipelinr.Command;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class GetOrderByIdQuery implements Command<GetOrderByIdQueryResponse> {
    private UUID id;
}
