package com.perfumeOnlineStore.controller.discount.command.updateDiscountCommand;

import an.awesome.pipelinr.Command;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UpdateDiscountCommand implements Command<UpdateDiscountCommandResponse> {
    @NotNull(message = "Discount's ID must be set")
    private Long id;
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
