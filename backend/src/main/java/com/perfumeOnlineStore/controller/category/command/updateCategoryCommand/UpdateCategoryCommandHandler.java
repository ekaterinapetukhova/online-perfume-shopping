package com.perfumeOnlineStore.controller.category.command.updateCategoryCommand;

import an.awesome.pipelinr.Command;
import com.perfumeOnlineStore.entity.Category;
import com.perfumeOnlineStore.mapper.category.UpdateCategoryCommandToCategoryMapper;
import com.perfumeOnlineStore.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UpdateCategoryCommandHandler implements Command.Handler<UpdateCategoryCommand, UpdateCategoryCommandResponse> {
    private final CategoryService categoryService;
    private final UpdateCategoryCommandValidator validator;

    public UpdateCategoryCommandResponse handle(UpdateCategoryCommand command) {
        UpdateCategoryCommandResponse resp = new UpdateCategoryCommandResponse();

        validator.validate(command);

        try {
            Optional<Category> existingCategory = categoryService.findCategoryById(command.getId());

            if (existingCategory.isPresent()) {
                Category category = UpdateCategoryCommandToCategoryMapper.INSTANCE.toCategory(command);

                categoryService.saveCategory(category);

                resp.setSuccess(true);
                resp.setStatus(HttpStatus.OK.name());
                resp.setStatusCode(HttpStatus.OK.value());
                resp.setPayload(category);
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
