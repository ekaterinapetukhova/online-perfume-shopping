package com.perfumeOnlineStore.controller.orderItem.query.getOrderItemByIdQuery;

import an.awesome.pipelinr.Command;
import com.perfumeOnlineStore.dto.OrderItemDto;
import com.perfumeOnlineStore.entity.OrderItem;
import com.perfumeOnlineStore.mapper.orderItem.OrderItemToDtoMapper;
import com.perfumeOnlineStore.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetOrderItemByIdQueryHandler implements Command.Handler<GetOrderItemByIdQuery, GetOrderItemByIdQueryResponse>{
    private final OrderItemService orderItemService;

    public GetOrderItemByIdQueryResponse handle(GetOrderItemByIdQuery query) {
        GetOrderItemByIdQueryResponse resp = new GetOrderItemByIdQueryResponse();

        try {
            Optional<OrderItem> existingOrderItem = orderItemService.findOrderItemById(query.getId());

            if (existingOrderItem.isPresent()) {
                OrderItemDto orderItemDto = existingOrderItem.map(OrderItemToDtoMapper.INSTANCE::toDto).get();

                resp.setSuccess(true);
                resp.setStatusCode(HttpStatus.OK.value());
                resp.setStatus(HttpStatus.OK.name());
                resp.setPayload(orderItemDto);
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
