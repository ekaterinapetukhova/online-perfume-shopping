package com.perfumeOnlineStore.controller.category.query.getAllCategoriesQuery;

import an.awesome.pipelinr.Command;
import com.perfumeOnlineStore.dto.CategoryDto;
import com.perfumeOnlineStore.entity.Category;
import com.perfumeOnlineStore.mapper.category.CategoryToDtoMapper;
import com.perfumeOnlineStore.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class GetAllCategoriesQueryHandler {
    private final CategoryService categoryService;

    public GetAllCategoriesQueryResponse handle() {
        GetAllCategoriesQueryResponse resp = new GetAllCategoriesQueryResponse();

        try {
            List<Category> categories = categoryService.findAllCategories();

            List<CategoryDto> categoriesDto = categories.stream()
                    .map(CategoryToDtoMapper.INSTANCE::toDto)
                    .toList();

            resp.setSuccess(true);
            resp.setStatusCode(HttpStatus.OK.value());
            resp.setStatus(HttpStatus.OK.name());
            resp.setPayload(categoriesDto);

            return resp;
        } catch (Exception e) {
            return resp;
        }
    }
}
