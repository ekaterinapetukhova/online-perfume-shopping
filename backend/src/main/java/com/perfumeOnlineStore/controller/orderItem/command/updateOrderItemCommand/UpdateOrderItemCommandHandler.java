package com.perfumeOnlineStore.controller.orderItem.command.updateOrderItemCommand;

import an.awesome.pipelinr.Command;
import com.perfumeOnlineStore.entity.OrderItem;
import com.perfumeOnlineStore.mapper.orderItem.UpdateOrderItemCommandToOrderItemMapper;
import com.perfumeOnlineStore.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UpdateOrderItemCommandHandler implements Command.Handler<UpdateOrderItemCommand, UpdateOrderItemCommandResponse> {
    private final OrderItemService orderItemService;
    private final UpdateOrderItemCommandValidator validator;

    public UpdateOrderItemCommandResponse handle(UpdateOrderItemCommand command) {
        UpdateOrderItemCommandResponse resp = new UpdateOrderItemCommandResponse();

        validator.validate(command);

        try {
            Optional<OrderItem> existingOrderItem = orderItemService.findOrderItemById(command.getId());

            if (existingOrderItem.isPresent()) {
                OrderItem orderItem = UpdateOrderItemCommandToOrderItemMapper.INSTANCE.toOrderItem(command);

                orderItemService.saveOrderItem(orderItem);

                resp.setSuccess(true);
                resp.setStatus(HttpStatus.OK.name());
                resp.setStatusCode(HttpStatus.OK.value());
                resp.setPayload(orderItem);
            } else {
                resp.setStatus(HttpStatus.NOT_FOUND.name());
                resp.setStatusCode(HttpStatus.NOT_FOUND.value());
                resp.setPayload(null);
            }

            return resp;
        } catch (Exception e) {
            return resp;
        }
    }
}
