package com.perfumeOnlineStore.controller.category.command.deleteCategoryCommand;

import an.awesome.pipelinr.Command;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class DeleteCategoryCommand implements Command<DeleteCategoryCommandResponse> {
    @NotNull(message = "Category's ID must be set")
    private Long id;
}
