package com.perfumeOnlineStore.controller.order.command.createOrderCommand;

import an.awesome.pipelinr.Command;
import com.perfumeOnlineStore.entity.Order;
import com.perfumeOnlineStore.mapper.order.CreateOrderCommandToOrderMapper;
import com.perfumeOnlineStore.service.OrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateOrderCommandHandler implements Command.Handler<CreateOrderCommand, CreateOrderCommandResponse> {
    private final OrderService orderService;
    private final CreateOrderCommandValidator validator;

    @Override
    @Transactional
    public CreateOrderCommandResponse handle(CreateOrderCommand command) {
        CreateOrderCommandResponse resp = new CreateOrderCommandResponse();

        validator.validate(command);

        try {
            Order order = CreateOrderCommandToOrderMapper.INSTANCE.toOrder(command);

            orderService.saveOrder(order);

            resp.setSuccess(true);
            resp.setStatusCode(HttpStatus.CREATED.value());
            resp.setStatus(HttpStatus.CREATED.name());
            resp.setPayload(order);

            return resp;
        } catch (Exception e) {
            return resp;
        }
    }
}
