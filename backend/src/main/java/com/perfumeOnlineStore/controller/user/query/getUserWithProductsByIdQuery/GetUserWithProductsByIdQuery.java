package com.perfumeOnlineStore.controller.user.query.getUserWithProductsByIdQuery;

import an.awesome.pipelinr.Command;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class GetUserWithProductsByIdQuery implements Command<GetUserWithProductsByIdQueryResponse> {
    private UUID id;
}
