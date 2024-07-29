package com.perfumeOnlineStore.controller.user.query.getUserByIdQuery;

import com.perfumeOnlineStore.dto.UserDto;
import com.perfumeOnlineStore.entity.User;
import com.perfumeOnlineStore.mapper.user.UserToUserDtoMapper;
import com.perfumeOnlineStore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetUserByIdQueryHandler {
    private final UserService userService;

    public GetUserByIdQueryResponse handle(Long id) {
        try {
            Optional<User> existingUser = userService.findUserById(id);

            if (existingUser.isPresent()) {
                UserDto userDto = existingUser.map(UserToUserDtoMapper.INSTANCE::toDto).get();

                return new GetUserByIdQueryResponse(userDto, HttpStatus.OK.value());
            } else return new GetUserByIdQueryResponse(null, HttpStatus.NOT_FOUND.value());
        } catch (Exception e) {
            return new GetUserByIdQueryResponse(null, HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }
}
