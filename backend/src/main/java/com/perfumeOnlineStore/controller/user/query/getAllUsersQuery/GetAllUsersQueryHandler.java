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

    public GetAllUsersQueryResponse handle() {
        try {
            List<User> users = userService.findAllUsers();

            List<UserDto> usersDto = users.stream()
                    .map(UserToUserDtoMapper.INSTANCE::toDto)
                    .toList();

            return new GetAllUsersQueryResponse(usersDto, HttpStatus.OK.value());
        } catch (Exception e) {
            return new GetAllUsersQueryResponse(null, HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }
}
