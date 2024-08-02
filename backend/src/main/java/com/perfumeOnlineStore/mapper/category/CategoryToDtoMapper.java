package com.perfumeOnlineStore.mapper.category;

import com.perfumeOnlineStore.dto.CategoryDto;
import com.perfumeOnlineStore.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryToDtoMapper {
    CategoryToDtoMapper INSTANCE = Mappers.getMapper(CategoryToDtoMapper.class);

    CategoryDto toDto(Category category);
}
