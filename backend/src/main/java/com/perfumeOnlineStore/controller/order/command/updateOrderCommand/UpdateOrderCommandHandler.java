package com.perfumeOnlineStore.controller.order.command.updateOrderCommand;

import an.awesome.pipelinr.Command;
import com.perfumeOnlineStore.entity.Order;
import com.perfumeOnlineStore.mapper.order.UpdateOrderCommandToOrderMapper;
import com.perfumeOnlineStore.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UpdateOrderCommandHandler implements Command.Handler<UpdateOrderCommand, UpdateOrderCommandResponse> {
    private final OrderService orderService;
    private final UpdateOrderCommandValidator validator;

    public UpdateOrderCommandResponse handle(UpdateOrderCommand command) {
        UpdateOrderCommandResponse resp = new UpdateOrderCommandResponse();

        validator.validate(command);

        try {
            Optional<Order> existingOrder = orderService.findOrderById(command.getId());

            if (existingOrder.isPresent()) {
                Order order = UpdateOrderCommandToOrderMapper.INSTANCE.toOrder(command);

                orderService.saveOrder(order);

                resp.setSuccess(true);
                resp.setStatus(HttpStatus.OK.name());
                resp.setStatusCode(HttpStatus.OK.value());
                resp.setPayload(order);
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
