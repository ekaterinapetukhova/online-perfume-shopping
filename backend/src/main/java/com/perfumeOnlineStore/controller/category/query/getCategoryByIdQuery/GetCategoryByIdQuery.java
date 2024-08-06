package com.perfumeOnlineStore.controller.category.query.getCategoryByIdQuery;

import an.awesome.pipelinr.Command;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class GetCategoryByIdQuery implements Command<GetCategoryByIdQueryResponse> {
    private Long id;
}
