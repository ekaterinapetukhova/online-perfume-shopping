package com.perfumeOnlineStore.controller.mail;

import an.awesome.pipelinr.Pipeline;
import com.perfumeOnlineStore.controller.mail.command.sendMailCommand.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/send-mail")
@RequiredArgsConstructor
public class MailController {
    private final Pipeline pipeline;

    @PostMapping
    public SendMailCommandResponse sendMail(@RequestParam String recipient,
                                            @RequestParam String subject,
                                            @RequestParam String controller,
                                            @RequestParam String action,
                                            @RequestParam boolean isSent) {
        SendMailCommand command = SendMailCommand.builder()
                .recipient(recipient)
                .action(action)
                .controller(controller)
                .isSentSuccessfully(isSent)
                .subject(subject)
                .build();

        return command.execute(pipeline);
    }
}
