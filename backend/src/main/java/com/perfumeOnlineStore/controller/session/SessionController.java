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


@Controller
@RequestMapping(("api/v1/auth"))
@RequiredArgsConstructor
public class SessionController {
    private final Pipeline pipeline;
    private final UserController userController;

    @PostMapping("/signin")
    public CreateSessionCommandResponse signIn(@RequestBody CreateSessionCommand createCommand) {
        return createCommand.execute(pipeline);
    }

    @GetMapping("/registration")
    public String showRegistration(Model model) {
        model.addAttribute("user", new UserDto());

        return "registration";
    }

    @PostMapping("/registration")
    public String register(@ModelAttribute("user") CreateUserCommand command) {

        userController.createUser(command);

        return "redirect:/result";
    }
}
