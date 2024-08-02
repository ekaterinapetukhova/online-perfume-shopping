package com.perfumeOnlineStore.controller.category;

import an.awesome.pipelinr.Pipeline;
import com.perfumeOnlineStore.controller.category.command.createCategoryCommand.*;
import com.perfumeOnlineStore.controller.category.command.deleteCategoryCommand.*;
import com.perfumeOnlineStore.controller.category.command.updateCategoryCommand.*;
import com.perfumeOnlineStore.controller.category.query.getAllCategoriesQuery.*;
import com.perfumeOnlineStore.controller.category.query.getCategoryByIdQuery.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final Pipeline pipeline;
    private final GetAllCategoriesQueryHandler getAllCategoriesQueryHandler;
    private final GetCategoryByIdQueryHandler getCategoryByIdQueryHandler;

    @GetMapping
    public GetAllCategoriesQueryResponse getAllCategories() {
        return getAllCategoriesQueryHandler.handle();
    }

    @GetMapping("/{categoryId}")
    public GetCategoryByIdQueryResponse getCategoryById(@PathVariable("categoryId") Long id) {
        return getCategoryByIdQueryHandler.handle(id);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public CreateCategoryCommandResponse createCategory(@RequestBody CreateCategoryCommand createCommand) {
        return createCommand.execute(pipeline);
    }

    @DeleteMapping("/{categoryId}")
    public DeleteCategoryCommandResponse deleteCategory(@PathVariable("categoryId") Long id) {
        DeleteCategoryCommand deleteCommand = new DeleteCategoryCommand(id);

        return deleteCommand.execute(pipeline);
    }

    @PutMapping(
            value = "/{categoryId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public UpdateCategoryCommandResponse updateProductById(@PathVariable("categoryId") Long id,
                                                           @RequestBody UpdateCategoryCommand updateCommand) {
        updateCommand.setId(id);

        return updateCommand.execute(pipeline);
    }
}
