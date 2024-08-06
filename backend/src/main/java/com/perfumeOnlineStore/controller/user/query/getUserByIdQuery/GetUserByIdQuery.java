package com.perfumeOnlineStore.controller.user.query.getUserByIdQuery;

import an.awesome.pipelinr.Command;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class GetUserByIdQuery implements Command<GetUserByIdQueryResponse> {
    private Long id;
}
