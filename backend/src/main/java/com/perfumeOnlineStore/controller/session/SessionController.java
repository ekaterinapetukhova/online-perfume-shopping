package com.perfumeOnlineStore.controller.session;

import an.awesome.pipelinr.Pipeline;
import com.perfumeOnlineStore.controller.session.command.createSessionCommand.CreateSessionCommand;
import com.perfumeOnlineStore.controller.session.command.createSessionCommand.CreateSessionCommandResponse;
import com.perfumeOnlineStore.controller.user.UserController;
import com.perfumeOnlineStore.controller.user.command.createUserCommand.CreateUserCommand;
import com.perfumeOnlineStore.dto.UserDto;
import com.perfumeOnlineStore.entity.User;
import com.perfumeOnlineStore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
