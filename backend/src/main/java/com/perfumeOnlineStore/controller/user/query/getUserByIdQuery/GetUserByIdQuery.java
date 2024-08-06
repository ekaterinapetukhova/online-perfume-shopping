package com.perfumeOnlineStore.controller.user.query.getUserByIdQuery;

import an.awesome.pipelinr.Command;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class GetUserByIdQuery implements Command<GetUserByIdQueryResponse> {
    private UUID id;
}
