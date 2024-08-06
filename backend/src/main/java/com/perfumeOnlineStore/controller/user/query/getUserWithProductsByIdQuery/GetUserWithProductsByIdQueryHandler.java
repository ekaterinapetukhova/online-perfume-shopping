package com.perfumeOnlineStore.controller.user.query.getUserWithProductsByIdQuery;

import an.awesome.pipelinr.Command;
import com.perfumeOnlineStore.dto.UserWithProductsDto;
import com.perfumeOnlineStore.entity.User;
import com.perfumeOnlineStore.mapper.userWithProducts.UserWithProductsToDtoMapper;
import com.perfumeOnlineStore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetUserWithProductsByIdQueryHandler implements Command.Handler<GetUserWithProductsByIdQuery, GetUserWithProductsByIdQueryResponse>{
    private final UserService userService;

    @Override
    public GetUserWithProductsByIdQueryResponse handle(GetUserWithProductsByIdQuery query) {
        GetUserWithProductsByIdQueryResponse resp = new GetUserWithProductsByIdQueryResponse();

        try {
            Optional<User> existingUser = userService.findUserById(query.getId());

            if (existingUser.isPresent()) {
                UserWithProductsDto userWithProductsDto = existingUser.map(UserWithProductsToDtoMapper.INSTANCE::toDto).get();

                resp.setSuccess(true);
                resp.setStatusCode(HttpStatus.OK.value());
                resp.setStatus(HttpStatus.OK.name());
                resp.setPayload(userWithProductsDto);
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
