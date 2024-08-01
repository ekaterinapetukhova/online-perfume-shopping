package com.perfumeOnlineStore.controller.user.query.getAllUsersQuery;

import com.perfumeOnlineStore.dto.UserDto;
import com.perfumeOnlineStore.entity.User;
import com.perfumeOnlineStore.mapper.user.UserToUserDtoMapper;
import com.perfumeOnlineStore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllUsersQueryHandler {
    private final UserService userService;

    public GetAllUsersQueryResponse handler() {
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
