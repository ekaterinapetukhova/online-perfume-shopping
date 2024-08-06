package com.perfumeOnlineStore.controller.user;

import an.awesome.pipelinr.Pipeline;
import com.perfumeOnlineStore.controller.user.command.createUserCommand.*;
import com.perfumeOnlineStore.controller.user.command.deleteUserCommand.*;
import com.perfumeOnlineStore.controller.user.command.updateUserCommand.UpdateUserCommand;
import com.perfumeOnlineStore.controller.user.command.updateUserCommand.UpdateUserCommandResponse;
import com.perfumeOnlineStore.controller.user.query.getAllUsersQuery.*;
import com.perfumeOnlineStore.controller.user.query.getAllUsersWithOrders.GetAllUsersWithOrdersQuery;
import com.perfumeOnlineStore.controller.user.query.getAllUsersWithOrders.GetAllUsersWithOrdersQueryResponse;
import com.perfumeOnlineStore.controller.user.query.getUserByIdQuery.*;
import com.perfumeOnlineStore.controller.user.query.getUserWithProductsByIdQuery.GetUserWithProductsByIdQuery;
import com.perfumeOnlineStore.controller.user.query.getUserWithProductsByIdQuery.GetUserWithProductsByIdQueryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final Pipeline pipeline;

    @GetMapping
    public GetAllUsersQueryResponse getAllUsers() {
        GetAllUsersQuery query = new GetAllUsersQuery();

        return query.execute(pipeline);
    }

    @GetMapping(params = "withOrders=true")
    public GetAllUsersWithOrdersQueryResponse getAllUsersWithOrders() {
        GetAllUsersWithOrdersQuery query = new GetAllUsersWithOrdersQuery();

        return query.execute(pipeline);
    }

    @GetMapping("/{userId}")
    public GetUserByIdQueryResponse getUserById(@PathVariable("userId") UUID id) {
        GetUserByIdQuery query = new GetUserByIdQuery(id);

        return query.execute(pipeline);
    }

    @GetMapping(value = "/{userId}", params = "withOrders=true")
    public GetUserWithProductsByIdQueryResponse getUserWithProductsById(@PathVariable("userId") UUID id) {
        GetUserWithProductsByIdQuery query = new GetUserWithProductsByIdQuery(id);

        return query.execute(pipeline);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public CreateUserCommandResponse createUser(@RequestBody CreateUserCommand createCommand) {
        return createCommand.execute(pipeline);
    }

    @DeleteMapping("/{userId}")
    public DeleteUserCommandResponse deleteUserById(@PathVariable("userId") UUID id) {
        DeleteUserCommand deleteCommand = new DeleteUserCommand(id);

        return deleteCommand.execute(pipeline);
    }

    @PutMapping("/{userId}")
    public UpdateUserCommandResponse updateUserById(@PathVariable("userId") UUID id,
                                                    @RequestBody UpdateUserCommand updateCommand) {
        updateCommand.setId(id);

        return updateCommand.execute(pipeline);
    }
}
