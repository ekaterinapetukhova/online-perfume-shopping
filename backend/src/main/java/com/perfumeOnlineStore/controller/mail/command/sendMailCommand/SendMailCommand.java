package com.perfumeOnlineStore.controller.mail.command.sendMailCommand;

import an.awesome.pipelinr.Command;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
public class SendMailCommand implements Command<SendMailCommandResponse> {
    private String recipient;
    private String subject;
    private String controller;
    private String action;
    @JsonProperty
    private boolean isSentSuccessfully;
}
