package com.perfumeOnlineStore.controller.session.command.createSessionCommand;

import an.awesome.pipelinr.Command;
import com.perfumeOnlineStore.dto.JwtResponseDto;
import com.perfumeOnlineStore.entity.RefreshToken;
import com.perfumeOnlineStore.entity.Session;
import com.perfumeOnlineStore.entity.User;
import com.perfumeOnlineStore.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CreateSessionCommandHandler implements Command.Handler<CreateSessionCommand, CreateSessionCommandResponse>{
    private final SessionService sessionService;
    private final RefreshTokenService refreshTokenService;
    private final JwtService jwtService;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final CreateSessionCommandValidator validator;

    @Override
    public CreateSessionCommandResponse handle(CreateSessionCommand createSessionCommand) {
        CreateSessionCommandResponse resp = new CreateSessionCommandResponse();

        validator.validate(createSessionCommand);

        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    createSessionCommand.getUsername(),
                    createSessionCommand.getPassword()
            );

            Authentication authentication = authenticationManager.authenticate(authenticationToken);

            SecurityContextHolder.getContext().setAuthentication(authentication);

            User user = userService.findUserByEmail(createSessionCommand.getUsername());

            Session session = sessionService.createNewSession(
                    user,
                    createSessionCommand.isRemembered()
            );

            RefreshToken refreshToken = refreshTokenService.createRefreshToken(session);

            String jwt = jwtService.generateToken(user);

            JwtResponseDto jwtResponseDto = JwtResponseDto.builder()
                    .accessToken(jwt)
                    .refreshToken(refreshToken.getToken())
                    .build();

            resp.setSuccess(true);
            resp.setStatus(HttpStatus.OK.name());
            resp.setStatusCode(HttpStatus.OK.value());
            resp.setPayload(jwtResponseDto);

            return resp;
        } catch (Exception e) {
            log.error(e.getMessage());
            return resp;
        }
    }
}
