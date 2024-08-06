package com.perfumeOnlineStore.controller.discount.query.getDiscountByIdQuery;

import an.awesome.pipelinr.Command;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class GetDiscountByIdQuery implements Command<GetDiscountByIdResponse> {
    private UUID id;
}
