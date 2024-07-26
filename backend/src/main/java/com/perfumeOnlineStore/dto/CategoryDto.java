package com.perfumeOnlineStore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryDto {
    private Long id;
    private String name;
    private String description;

    public CategoryDto(
            String name,
            String description
    ) {
        this.name = name;
        this.description = description;
    }
}
