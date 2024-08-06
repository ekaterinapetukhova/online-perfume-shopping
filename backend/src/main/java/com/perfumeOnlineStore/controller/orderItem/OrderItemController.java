package com.perfumeOnlineStore.controller.orderItem;

import an.awesome.pipelinr.Pipeline;

import com.perfumeOnlineStore.controller.orderItem.command.createOrderItemCommand.*;
import com.perfumeOnlineStore.controller.orderItem.command.deleteOrderItemCommand.*;
import com.perfumeOnlineStore.controller.orderItem.command.updateOrderItemCommand.*;
import com.perfumeOnlineStore.controller.orderItem.query.getAllOrderItemsQuery.*;
import com.perfumeOnlineStore.controller.orderItem.query.getOrderItemByIdQuery.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/order_items")
@RequiredArgsConstructor
public class OrderItemController {
    private final Pipeline pipeline;
    private final GetAllOrderItemsQueryHandler getAllOrderItemsQueryHandler;

    @GetMapping
    public GetAllOrderItemsQueryResponse getAllProducts() {
        return getAllOrderItemsQueryHandler.handle();
    }

    @GetMapping("/{orderItemId}")
    public GetOrderItemByIdQueryResponse getOrderItemById(@PathVariable("orderItemId") UUID id) {
        GetOrderItemByIdQuery query = new GetOrderItemByIdQuery(id);

        return query.execute(pipeline);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public CreateOrderItemCommandResponse createOrderItem(@RequestBody CreateOrderItemCommand createCommand) {
        return createCommand.execute(pipeline);
    }

    @DeleteMapping("/{orderItemId}")
    public DeleteOrderItemCommandResponse deleteOrderItem(@PathVariable("orderItemId") UUID id) {
        DeleteOrderItemCommand deleteCommand = new DeleteOrderItemCommand(id);

        return deleteCommand.execute(pipeline);
    }

    @PutMapping(
            value = "/{orderItemId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public UpdateOrderItemCommandResponse updateOrderItemById(@PathVariable("orderItemId") UUID id,
                                                              @RequestBody UpdateOrderItemCommand updateCommand) {
        updateCommand.setId(id);

        return updateCommand.execute(pipeline);
    }
}
