package com.perfumeOnlineStore.mapper.category;

import com.perfumeOnlineStore.controller.category.command.createCategoryCommand.CreateCategoryCommand;
import com.perfumeOnlineStore.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CreateCategoryCommandToCategoryMapper {
    CreateCategoryCommandToCategoryMapper INSTANCE = Mappers.getMapper(CreateCategoryCommandToCategoryMapper.class);

    Category toCategory(CreateCategoryCommand command);
}
