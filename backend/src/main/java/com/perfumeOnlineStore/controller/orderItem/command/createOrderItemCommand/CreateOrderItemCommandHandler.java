package com.perfumeOnlineStore.controller.orderItem.command.createOrderItemCommand;

import an.awesome.pipelinr.Command;
import com.perfumeOnlineStore.entity.OrderItem;
import com.perfumeOnlineStore.mapper.orderItem.CreateOrderItemCommandToOrderItemMapper;
import com.perfumeOnlineStore.service.OrderItemService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateOrderItemCommandHandler implements Command.Handler<CreateOrderItemCommand, CreateOrderItemCommandResponse> {
    private final OrderItemService orderItemService;
    private final CreateOrderItemCommandValidator validator;

    @Override
    @Transactional
    public CreateOrderItemCommandResponse handle(CreateOrderItemCommand command) {
        CreateOrderItemCommandResponse resp = new CreateOrderItemCommandResponse();

        validator.validate(command);

        try {
            OrderItem orderItem = CreateOrderItemCommandToOrderItemMapper.INSTANCE.toOrderItem(command);

            orderItemService.saveOrderItem(orderItem);

            resp.setSuccess(true);
            resp.setStatusCode(HttpStatus.CREATED.value());
            resp.setStatus(HttpStatus.CREATED.name());
            resp.setPayload(orderItem);

            return resp;
        } catch (Exception e) {
            return resp;
        }
    }
}
