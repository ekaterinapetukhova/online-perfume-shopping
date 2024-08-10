package com.perfumeOnlineStore.controller.authentication.command.createAuthenticationRegisterCommand;

import an.awesome.pipelinr.Command;
import com.perfumeOnlineStore.controller.authentication.command.CreateAuthenticationRegisterCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateAuthenticationRegisterHandler implements Command.Handler<CreateAuthenticationRegisterCommand, CreateAuthenticationRegisterResponse>{

    @Override
    public CreateAuthenticationRegisterResponse handle(CreateAuthenticationRegisterCommand createAuthenticationRegisterCommand) {
        return null;
    }
}
