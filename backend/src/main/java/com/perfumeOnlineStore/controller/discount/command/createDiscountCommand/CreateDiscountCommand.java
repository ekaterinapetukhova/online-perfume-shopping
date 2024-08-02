package com.perfumeOnlineStore.controller.discount.command.createDiscountCommand;

import an.awesome.pipelinr.Command;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateDiscountCommand implements Command<CreateDiscountCommandResponse> {
    @NotNull(message = "Discount's percent must be set")
    private Double percent;
    @NotEmpty(message = "Discount's name must be set")
    private String name;
    @NotNull(message = "Discount's started date must be set")
    private LocalDateTime startedDate;
    @NotNull(message = "Discount's ended date must be set")
    private LocalDateTime endedDate;
    @NotEmpty(message = "Discount's description must be set")
    private String description;
}
