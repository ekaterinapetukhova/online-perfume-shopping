package com.perfumeOnlineStore.controller.user.command.deleteUserCommand;

import an.awesome.pipelinr.Command;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class DeleteUserCommand implements Command<DeleteUserCommandResponse> {
    @NotNull(message = "ID must be set")
    private UUID id;
}
