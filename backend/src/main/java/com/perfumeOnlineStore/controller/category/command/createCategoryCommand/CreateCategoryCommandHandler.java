package com.perfumeOnlineStore.controller.category.command.createCategoryCommand;

import an.awesome.pipelinr.Command;
import com.perfumeOnlineStore.entity.Category;
import com.perfumeOnlineStore.mapper.category.CreateCategoryCommandToCategoryMapper;
import com.perfumeOnlineStore.service.CategoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateCategoryCommandHandler implements Command.Handler<CreateCategoryCommand, CreateCategoryCommandResponse>{
    private final CategoryService categoryService;
    private final CreateCategoryCommandValidator validator;

    @Override
    @Transactional
    public CreateCategoryCommandResponse handle(CreateCategoryCommand command) {
        CreateCategoryCommandResponse resp = new CreateCategoryCommandResponse();

        validator.validate(command);

        try {
            Category category = CreateCategoryCommandToCategoryMapper.INSTANCE.toCategory(command);

            categoryService.saveCategory(category);

            resp.setSuccess(true);
            resp.setStatusCode(HttpStatus.CREATED.value());
            resp.setStatus(HttpStatus.CREATED.name());
            resp.setPayload(category);

            return resp;
        } catch (Exception e) {
            return resp;
        }
    }
}
