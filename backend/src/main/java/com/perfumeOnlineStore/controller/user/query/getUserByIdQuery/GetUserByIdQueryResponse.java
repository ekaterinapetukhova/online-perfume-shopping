package com.perfumeOnlineStore.controller.user.query.getUserByIdQuery;

import com.perfumeOnlineStore.dto.UserDto;

public record GetUserByIdQueryResponse(UserDto userDto, int statusCode) {
}
