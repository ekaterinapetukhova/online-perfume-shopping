package com.perfumeOnlineStore.controller.session;

import an.awesome.pipelinr.Pipeline;
import com.perfumeOnlineStore.controller.session.command.createSessionCommand.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(("api/v1/auth"))
@RequiredArgsConstructor
public class SessionController {
    private final Pipeline pipeline;

    @PostMapping("/signin")
    public CreateSessionCommandResponse signIn(@RequestBody CreateSessionCommand createCommand) {
        return createCommand.execute(pipeline);
    }
}
