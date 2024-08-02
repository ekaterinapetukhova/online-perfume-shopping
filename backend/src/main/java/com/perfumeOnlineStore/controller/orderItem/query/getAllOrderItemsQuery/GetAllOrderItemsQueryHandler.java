package com.perfumeOnlineStore.controller.orderItem.query.getAllOrderItemsQuery;

import com.perfumeOnlineStore.dto.OrderItemDto;
import com.perfumeOnlineStore.entity.OrderItem;
import com.perfumeOnlineStore.mapper.orderItem.OrderItemToDtoMapper;
import com.perfumeOnlineStore.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllOrderItemsQueryHandler {
    private final OrderItemService orderItemService;

    public GetAllOrderItemsQueryResponse handle() {
        GetAllOrderItemsQueryResponse resp = new GetAllOrderItemsQueryResponse();

        try {
            List<OrderItem> orderItems = orderItemService.findAllOrderItems();

            List<OrderItemDto> orderItemsDto = orderItems.stream()
                    .map(OrderItemToDtoMapper.INSTANCE::toDto)
                    .toList();

            resp.setSuccess(true);
            resp.setStatusCode(HttpStatus.OK.value());
            resp.setStatus(HttpStatus.OK.name());
            resp.setPayload(orderItemsDto);

            return resp;
        } catch (Exception e) {
            return resp;
        }
    }
}
