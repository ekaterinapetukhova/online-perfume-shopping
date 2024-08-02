package com.perfumeOnlineStore.mapper.category;

import com.perfumeOnlineStore.controller.category.command.updateCategoryCommand.UpdateCategoryCommand;
import com.perfumeOnlineStore.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UpdateCategoryCommandToCategoryMapper {
    UpdateCategoryCommandToCategoryMapper INSTANCE = Mappers.getMapper(UpdateCategoryCommandToCategoryMapper.class);

    Category toCategory(UpdateCategoryCommand command);
}
