package com.perfumeOnlineStore.controller.category.command.createCategoryCommand;

import an.awesome.pipelinr.Command;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
public class CreateCategoryCommand implements Command<CreateCategoryCommandResponse> {
    @NotEmpty(message = "Category's name must be set")
    private String name;
    @NotEmpty(message = "Category's description must be set")
    private String description;
}
