package com.perfumeOnlineStore.controller.orderItem.command.addToCartCommand;

import an.awesome.pipelinr.Command;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AddToCartCommand implements Command<AddToCartCommandResponse> {
    private UUID id;
    private Integer quantity;
    private Double price;
    private String cartCookie;
}
