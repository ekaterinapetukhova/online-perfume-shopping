package com.perfumeOnlineStore.controller.order;

import com.perfumeOnlineStore.entity.Order;
import com.perfumeOnlineStore.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.findAllOrders();

        return !orders.isEmpty() ? new ResponseEntity<>(orders, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable("orderId") Long orderId) {
        Optional<Order> order = orderService.findOrderById(orderId);

        return order.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Order> createOrder(@RequestBody Order newOrder) {
        try {
            orderService.saveOrder(newOrder);
            return new ResponseEntity<>(newOrder, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<HttpStatus> deleteOrder(@PathVariable("orderId") Long orderId) {
        Optional<Order> existingOrder = orderService.findOrderById(orderId);
        if (existingOrder.isPresent()) {
            orderService.deleteOrder(existingOrder.get());
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping(
            value = "/{orderId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Order> updateOrderById(@PathVariable("orderId") Long orderId,
                                                 @RequestBody Order updatedOrder) {
        Optional<Order> existingOrder = orderService.findOrderById(orderId);

        if (existingOrder.isPresent()) {
            Order order = existingOrder.get();

            order.setDate(updatedOrder.getDate());
            order.setStatus(updatedOrder.getStatus());
            order.setTotalPrice(updatedOrder.getTotalPrice());

            orderService.saveOrder(order);

            return ResponseEntity.ok(order);
        } else return ResponseEntity.notFound().build();
    }
}
