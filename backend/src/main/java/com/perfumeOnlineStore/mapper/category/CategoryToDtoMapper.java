package com.perfumeOnlineStore.mapper.category;

import com.perfumeOnlineStore.dto.CategoryDto;
import com.perfumeOnlineStore.entity.Category;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryToDtoMapper {
    CategoryToDtoMapper INSTANCE = Mappers.getMapper(CategoryToDtoMapper.class);

    CategoryDto toDto(Category category);

    @AfterMapping
    default void addProductsToDto(Category category, CategoryDto categoryDto) {
        categoryDto.setProducts(category.getProducts());
    }
}
