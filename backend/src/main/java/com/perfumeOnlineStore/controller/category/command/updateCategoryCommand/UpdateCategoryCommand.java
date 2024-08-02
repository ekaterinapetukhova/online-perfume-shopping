package com.perfumeOnlineStore.controller.category.command.updateCategoryCommand;

import an.awesome.pipelinr.Command;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCategoryCommand implements Command<UpdateCategoryCommandResponse> {
    @NotNull(message = "Category's ID must be set")
    private Long id;
    @NotEmpty(message = "Category's name must be set")
    private String name;
    @NotEmpty(message = "Category's description must be set")
    private String description;
}
