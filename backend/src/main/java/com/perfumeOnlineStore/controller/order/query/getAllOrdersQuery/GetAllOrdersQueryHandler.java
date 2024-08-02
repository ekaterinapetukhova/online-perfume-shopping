package com.perfumeOnlineStore.controller.order.query.getAllOrdersQuery;

import com.perfumeOnlineStore.controller.response.ResponseBase;
import com.perfumeOnlineStore.dto.OrderDto;
import com.perfumeOnlineStore.entity.Order;
import com.perfumeOnlineStore.mapper.order.OrderToDtoMapper;
import com.perfumeOnlineStore.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllOrdersQueryHandler {
    private final OrderService orderService;

    public GetAllOrdersQueryResponse handle() {
        GetAllOrdersQueryResponse resp = new GetAllOrdersQueryResponse();

        try {
            List<Order> orders = orderService.findAllOrders();

            List<OrderDto> ordersDto = orders.stream()
                    .map(OrderToDtoMapper.INSTANCE::toDto)
                    .toList();

            resp.setSuccess(true);
            resp.setStatusCode(HttpStatus.OK.value());
            resp.setStatus(HttpStatus.OK.name());
            resp.setPayload(ordersDto);

            return resp;
        } catch (Exception e) {
            return resp;
        }
    }
}
