package com.perfumeOnlineStore.orderItem;

import com.perfumeOnlineStore.discount.Discount;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/order_items")
@RequiredArgsConstructor
public class OrderItemController {
    private final OrderItemService orderItemService;

    @GetMapping
    public ResponseEntity<List<OrderItem>> getAllProducts() {
        List<OrderItem> orderItems = orderItemService.findAllOrderItems();

        return !orderItems.isEmpty() ? new ResponseEntity<>(orderItems, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{orderItemId}")
    public ResponseEntity<OrderItem> getOrderItemById(@PathVariable("orderItemId") Long orderItemId) {
        Optional<OrderItem> orderItem = orderItemService.findOrderItemById(orderItemId);

        return orderItem.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItem newOrderItem) {
        try {
            orderItemService.saveOrderItem(newOrderItem);
            return new ResponseEntity<>(newOrderItem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{orderItemId}")
    public ResponseEntity<HttpStatus> deleteOrderItem(@PathVariable("orderItemId") Long orderItemId) {
        Optional<OrderItem> existingOrderItem = orderItemService.findOrderItemById(orderItemId);
        if (existingOrderItem.isPresent()) {
            orderItemService.deleteOrderItem(existingOrderItem.get());
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping(
            value = "/{orderItemId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<OrderItem> updateOrderItemById(@PathVariable("orderItemId") Long orderItemId,
                                                   @RequestBody OrderItem updatedOrderItem) {
        Optional<OrderItem> existingOrderItem = orderItemService.findOrderItemById(orderItemId);

        if (existingOrderItem.isPresent()) {
            OrderItem orderItem = existingOrderItem.get();

            orderItem.setPrice(updatedOrderItem.getPrice());
            orderItem.setQuantity(updatedOrderItem.getQuantity());
            orderItem.setProducts(updatedOrderItem.getProducts());

            return ResponseEntity.ok(orderItem);
        } else return ResponseEntity.notFound().build();
    }
}
