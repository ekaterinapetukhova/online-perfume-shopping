package com.perfumeOnlineStore.controller.order.query.getOrderByIdQuery;

import an.awesome.pipelinr.Command;
import com.perfumeOnlineStore.dto.OrderDto;
import com.perfumeOnlineStore.entity.Order;
import com.perfumeOnlineStore.mapper.order.OrderToDtoMapper;
import com.perfumeOnlineStore.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class GetOrderByIdQueryHandler implements Command.Handler<GetOrderByIdQuery, GetOrderByIdQueryResponse>{
    private final OrderService orderService;

    public GetOrderByIdQueryResponse handle(GetOrderByIdQuery query) {
        GetOrderByIdQueryResponse resp = new GetOrderByIdQueryResponse();

        try {
            Optional<Order> existingOrder = orderService.findOrderById(query.getId());

            if (existingOrder.isPresent()) {
                OrderDto orderDto = existingOrder.map(OrderToDtoMapper.INSTANCE::toDto).get();

                resp.setSuccess(true);
                resp.setStatusCode(HttpStatus.OK.value());
                resp.setStatus(HttpStatus.OK.name());
                resp.setPayload(orderDto);
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
