package com.perfumeOnlineStore.controller.user.command.deleteUserCommand;

import an.awesome.pipelinr.Command;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
public class DeleteUserCommand implements Command<DeleteUserCommandResponse> {
    @NotNull(message = "ID must be set")
    private Long id;
}
