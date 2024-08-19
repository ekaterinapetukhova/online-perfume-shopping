package com.perfumeOnlineStore.controller.session.command.createSessionCommand;

import an.awesome.pipelinr.Command;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
public class CreateSessionCommand implements Command<CreateSessionCommandResponse> {
    @NotEmpty(message = "Username must be set")
    private String username;
    @NotEmpty(message = "Password must be set")
    private String password;
    @NotNull(message = "Remembering of user's session must be set")
    @JsonProperty
    private boolean isRemembered;
}
