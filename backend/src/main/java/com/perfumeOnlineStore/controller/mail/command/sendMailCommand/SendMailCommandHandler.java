package com.perfumeOnlineStore.controller.mail.command.sendMailCommand;

import an.awesome.pipelinr.Command;
import org.springframework.stereotype.Component;

@Component
public class SendMailCommandHandler implements Command.Handler<SendMailCommand, SendMailCommandResponse> {
    @Override
    public SendMailCommandResponse handle(SendMailCommand sendMailCommand) {
        return null;
    }
}
