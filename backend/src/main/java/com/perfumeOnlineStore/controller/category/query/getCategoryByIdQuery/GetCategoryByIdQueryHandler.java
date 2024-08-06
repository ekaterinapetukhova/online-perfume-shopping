package com.perfumeOnlineStore.controller.category.query.getCategoryByIdQuery;

import an.awesome.pipelinr.Command;
import com.perfumeOnlineStore.dto.CategoryDto;
import com.perfumeOnlineStore.entity.Category;
import com.perfumeOnlineStore.mapper.category.CategoryToDtoMapper;
import com.perfumeOnlineStore.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetCategoryByIdQueryHandler implements Command.Handler<GetCategoryByIdQuery, GetCategoryByIdQueryResponse> {
    private final CategoryService categoryService;

    public GetCategoryByIdQueryResponse handle(GetCategoryByIdQuery query) {
        GetCategoryByIdQueryResponse resp = new GetCategoryByIdQueryResponse();

        try {
            Optional<Category> existingCategory = categoryService.findCategoryById(query.getId());

            if (existingCategory.isPresent()) {
                CategoryDto categoryDto = existingCategory.map(CategoryToDtoMapper.INSTANCE::toDto).get();

                resp.setSuccess(true);
                resp.setStatusCode(HttpStatus.OK.value());
                resp.setStatus(HttpStatus.OK.name());
                resp.setPayload(categoryDto);
            } else {
                resp.setStatusCode(HttpStatus.NOT_FOUND.value());
                resp.setStatus(HttpStatus.NOT_FOUND.name());
                resp.setPayload(null);
            }

            return resp;
        } catch (Exception e) {
            return resp;
        }
    }
}
