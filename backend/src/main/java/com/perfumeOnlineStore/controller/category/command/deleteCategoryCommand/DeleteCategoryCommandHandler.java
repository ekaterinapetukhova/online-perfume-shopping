package com.perfumeOnlineStore.controller.category.command.deleteCategoryCommand;

import an.awesome.pipelinr.Command;
import com.perfumeOnlineStore.entity.Category;
import com.perfumeOnlineStore.service.CategoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DeleteCategoryCommandHandler implements Command.Handler<DeleteCategoryCommand, DeleteCategoryCommandResponse>{
    private final CategoryService categoryService;
    private final DeleteCategoryCommandValidator validator;

    @Transactional
    @Override
    public DeleteCategoryCommandResponse handle(DeleteCategoryCommand command) {
        DeleteCategoryCommandResponse resp = new DeleteCategoryCommandResponse();

        validator.validate(command);

        try {
            Optional<Category> existingCategory = categoryService.findCategoryById(command.getId());

            if (existingCategory.isPresent()) {
                categoryService.deleteCategory(existingCategory.get());

                resp.setSuccess(true);
                resp.setStatus(HttpStatus.NO_CONTENT.name());
                resp.setStatusCode(HttpStatus.NO_CONTENT.value());
                resp.setPayload(existingCategory.get().getId());
            } else {
                resp.setStatus(HttpStatus.NOT_FOUND.name());
                resp.setStatusCode(HttpStatus.NOT_FOUND.value());
                resp.setPayload(null);
            }

            return resp;
        } catch (Exception e) {
            return resp;
        }
    }
}
