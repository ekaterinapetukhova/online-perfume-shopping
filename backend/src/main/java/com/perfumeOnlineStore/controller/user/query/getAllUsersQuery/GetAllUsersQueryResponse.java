package com.perfumeOnlineStore.controller.user.query.getAllUsersQuery;

import com.perfumeOnlineStore.dto.UserDto;

import java.util.List;

public record GetAllUsersQueryResponse(List<UserDto> usersDto, int statusCode) {

}
