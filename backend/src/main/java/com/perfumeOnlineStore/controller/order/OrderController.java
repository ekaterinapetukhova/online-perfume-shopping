package com.perfumeOnlineStore.controller.order;

import an.awesome.pipelinr.Pipeline;
import com.perfumeOnlineStore.controller.order.command.createOrderCommand.*;
import com.perfumeOnlineStore.controller.order.command.deleteOrderCommand.*;
import com.perfumeOnlineStore.controller.order.command.updateOrderCommand.*;
import com.perfumeOnlineStore.controller.order.query.getAllOrdersQuery.*;
import com.perfumeOnlineStore.controller.order.query.getOrderByIdQuery.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final Pipeline pipeline;
    private final GetAllOrdersQueryHandler getAllOrdersQueryHandler;

    @GetMapping
    public GetAllOrdersQueryResponse getAllOrders() {
       return getAllOrdersQueryHandler.handle();
    }

    @GetMapping("/{orderId}")
    public GetOrderByIdQueryResponse getOrderById(@PathVariable("orderId") Long id) {
        GetOrderByIdQuery query = new GetOrderByIdQuery(id);

        return query.execute(pipeline);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public CreateOrderCommandResponse createOrder(@RequestBody CreateOrderCommand createCommand) {
        return createCommand.execute(pipeline);
    }

    @DeleteMapping("/{orderId}")
    public DeleteOrderCommandResponse deleteOrder(@PathVariable("orderId") Long id) {
        DeleteOrderCommand deleteCommand = new DeleteOrderCommand(id);

        return deleteCommand.execute(pipeline);
    }

    @PutMapping(
            value = "/{orderId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public UpdateOrderCommandResponse updateOrderById(@PathVariable("orderId") Long id,
                                                      @RequestBody UpdateOrderCommand updateCommand) {
        updateCommand.setId(id);

        return updateCommand.execute(pipeline);
    }
}
