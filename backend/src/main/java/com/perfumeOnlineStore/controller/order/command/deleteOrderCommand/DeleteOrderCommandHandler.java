package com.perfumeOnlineStore.controller.order.command.deleteOrderCommand;

import an.awesome.pipelinr.Command;
import com.perfumeOnlineStore.entity.Order;
import com.perfumeOnlineStore.service.OrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DeleteOrderCommandHandler implements Command.Handler<DeleteOrderCommand, DeleteOrderCommandResponse> {
    private final OrderService orderService;
    private final DeleteOrderCommandValidator validator;

    @Transactional
    @Override
    public DeleteOrderCommandResponse handle(DeleteOrderCommand command) {
        DeleteOrderCommandResponse resp = new DeleteOrderCommandResponse();

        validator.validate(command);

        try {
            Optional<Order> existingOrder = orderService.findOrderById(command.getId());

            if (existingOrder.isPresent()) {
                orderService.deleteOrder(existingOrder.get());

                resp.setSuccess(true);
                resp.setStatus(HttpStatus.NO_CONTENT.name());
                resp.setStatusCode(HttpStatus.NO_CONTENT.value());
                resp.setPayload(existingOrder.get().getId());
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
