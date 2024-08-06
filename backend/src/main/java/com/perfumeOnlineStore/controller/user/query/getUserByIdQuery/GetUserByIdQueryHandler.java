package com.perfumeOnlineStore.controller.user.query.getUserByIdQuery;

import an.awesome.pipelinr.Command;
import com.perfumeOnlineStore.dto.UserDto;
import com.perfumeOnlineStore.entity.User;
import com.perfumeOnlineStore.mapper.user.UserToUserDtoMapper;
import com.perfumeOnlineStore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetUserByIdQueryHandler implements Command.Handler<GetUserByIdQuery, GetUserByIdQueryResponse>{
    private final UserService userService;

    public GetUserByIdQueryResponse handle(GetUserByIdQuery query) {
        GetUserByIdQueryResponse resp = new GetUserByIdQueryResponse();

        try {
            Optional<User> existingUser = userService.findUserById(query.getId());

            if (existingUser.isPresent()) {
                UserDto userDto = existingUser.map(UserToUserDtoMapper.INSTANCE::toDto).get();

                resp.setSuccess(true);
                resp.setStatusCode(HttpStatus.OK.value());
                resp.setStatus(HttpStatus.OK.name());
                resp.setPayload(userDto);
            } else {
                resp.setStatusCode(HttpStatus.NOT_FOUND.value());
                resp.setStatus(HttpStatus.NOT_FOUND.name());
                resp.setPayload(null);
            }

            return resp;
        } catch (Exception e) {
            return resp;
        }
    }
}
