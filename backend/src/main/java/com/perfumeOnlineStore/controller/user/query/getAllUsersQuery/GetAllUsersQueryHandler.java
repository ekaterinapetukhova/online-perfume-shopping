package com.perfumeOnlineStore.controller.user.query.getAllUsersQuery;

import an.awesome.pipelinr.Command;
import com.perfumeOnlineStore.dto.UserDto;
import com.perfumeOnlineStore.entity.User;
import com.perfumeOnlineStore.mapper.user.UserToUserDtoMapper;
import com.perfumeOnlineStore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllUsersQueryHandler implements Command.Handler<GetAllUsersQuery, GetAllUsersQueryResponse> {
    private final UserService userService;

    public GetAllUsersQueryResponse handle(GetAllUsersQuery query) {
        GetAllUsersQueryResponse resp = new GetAllUsersQueryResponse();

        try {
            List<User> users = userService.findAllUsers();

            List<UserDto> usersDto = users.stream()
                    .map(UserToUserDtoMapper.INSTANCE::toDto)
                    .toList();

            resp.setSuccess(true);
            resp.setStatusCode(HttpStatus.OK.value());
            resp.setStatus(HttpStatus.OK.name());
            resp.setPayload(usersDto);

            return resp;
        } catch (Exception e) {
            return resp;
        }
    }
}
