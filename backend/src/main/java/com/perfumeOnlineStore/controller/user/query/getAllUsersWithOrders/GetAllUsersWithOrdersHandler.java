package com.perfumeOnlineStore.controller.user.query.getAllUsersWithOrders;

import an.awesome.pipelinr.Command;
import com.perfumeOnlineStore.dto.UserWithProductsDto;
import com.perfumeOnlineStore.entity.User;
import com.perfumeOnlineStore.mapper.userWithProducts.UserWithProductsToDtoMapper;
import com.perfumeOnlineStore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllUsersWithOrdersHandler implements Command.Handler<GetAllUsersWithOrdersQuery, GetAllUsersWithOrdersQueryResponse> {
    private final UserService userService;

    @Override
    public GetAllUsersWithOrdersQueryResponse handle(GetAllUsersWithOrdersQuery query) {
        GetAllUsersWithOrdersQueryResponse resp = new GetAllUsersWithOrdersQueryResponse();

        try {
            List<User> users = userService.findAllUsers();

            List<UserWithProductsDto> usersWithProductsDto = users.stream()
                    .map(UserWithProductsToDtoMapper.INSTANCE::toDto)
                    .toList();

            resp.setSuccess(true);
            resp.setStatusCode(HttpStatus.OK.value());
            resp.setStatus(HttpStatus.OK.name());
            resp.setPayload(usersWithProductsDto);

            return resp;
        } catch (Exception e) {
            return resp;
        }
    }
}
