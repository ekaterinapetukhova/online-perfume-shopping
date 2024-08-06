package com.perfumeOnlineStore.controller.discount.query.getDiscountByIdQuery;

import an.awesome.pipelinr.Command;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class GetDiscountByIdQuery implements Command<GetDiscountByIdResponse> {
    private Long id;
}
