package com.perfumeOnlineStore.controller.discount.command.deleteDiscountCommand;

import an.awesome.pipelinr.Command;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class DeleteDiscountCommand implements Command<DeleteDiscountCommandResponse> {
    @NotNull(message = "Discount's ID must be set")
    private Long id;
}
