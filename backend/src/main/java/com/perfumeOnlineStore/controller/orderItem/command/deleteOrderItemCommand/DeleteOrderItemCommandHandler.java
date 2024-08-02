package com.perfumeOnlineStore.controller.orderItem.command.deleteOrderItemCommand;

import an.awesome.pipelinr.Command;
import com.perfumeOnlineStore.entity.OrderItem;
import com.perfumeOnlineStore.service.OrderItemService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DeleteOrderItemCommandHandler implements Command.Handler<DeleteOrderItemCommand, DeleteOrderItemCommandResponse> {
    private final OrderItemService orderItemService;
    private final DeleteOrderItemCommandValidator validator;

    @Transactional
    @Override
    public DeleteOrderItemCommandResponse handle(DeleteOrderItemCommand command) {
        DeleteOrderItemCommandResponse resp = new DeleteOrderItemCommandResponse();

        validator.validate(command);

        try {
            Optional<OrderItem> existingOrderItem = orderItemService.findOrderItemById(command.getId());

            if (existingOrderItem.isPresent()) {
                orderItemService.deleteOrderItem(existingOrderItem.get());

                resp.setSuccess(true);
                resp.setStatus(HttpStatus.NO_CONTENT.name());
                resp.setStatusCode(HttpStatus.NO_CONTENT.value());
                resp.setPayload(existingOrderItem.get().getId());
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
