package com.perfumeOnlineStore.controller.orderItem.command.addToCartCommand;

import an.awesome.pipelinr.Command;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.perfumeOnlineStore.entity.OrderItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AddToCartCommandHandler implements Command.Handler<AddToCartCommand, AddToCartCommandResponse> {
    private final ObjectMapper objectMapper;

    @Override
    public AddToCartCommandResponse handle(AddToCartCommand addToCartCommand) {
        List<OrderItem> cartItems;
        String cartCookie = addToCartCommand.getCartCookie();
        boolean itemExists = false;

        try {
            if (!cartCookie.isEmpty()) {
                cartItems = objectMapper.readValue(cartCookie, objectMapper.getTypeFactory().constructCollectionType(List.class, OrderItem.class));
            } else {
                cartItems = new ArrayList<>();
            }

            for (OrderItem item : cartItems) {
                if (item.getId().equals(addToCartCommand.getId())) {
                    item.setQuantity(item.getQuantity() + addToCartCommand.getQuantity());
                    item.setPrice(item.getPrice() + addToCartCommand.getPrice());
                    itemExists = true;
                    break;
                }
            }

            if (!itemExists) {
                OrderItem orderItem = OrderItem.builder()
                        .price(addToCartCommand.getPrice())
                        .quantity(addToCartCommand.getQuantity())
                        .build();

                cartItems.add(orderItem);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return new AddToCartCommandResponse();
    }
}
