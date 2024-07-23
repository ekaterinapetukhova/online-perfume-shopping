package com.perfumeOnlineStore.controller;

import com.perfumeOnlineStore.entity.Category;
import com.perfumeOnlineStore.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.findAllCategories();

        return !categories.isEmpty() ? new ResponseEntity<>(categories, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("categoryId") Long categoryId) {
        Optional<Category> category = categoryService.findCategoryById(categoryId);

        return category.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Category> createCategory(@RequestBody Category newCategory) {
        try {
            categoryService.saveCategory(newCategory);
            return new ResponseEntity<>(newCategory, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable("categoryId") Long categoryId) {
        Optional<Category> existingCategory = categoryService.findCategoryById(categoryId);
        if (existingCategory.isPresent()) {
            categoryService.deleteCategory(existingCategory.get());
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping(
            value = "/{categoryId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Category> updateProductById(@PathVariable("categoryId") Long categoryId,
                                                     @RequestBody Category updatedCategory) {
        Optional<Category> existingCategory = categoryService.findCategoryById(categoryId);

        if (existingCategory.isPresent()) {
            Category category = existingCategory.get();

            category.setName(updatedCategory.getName());
            category.setDescription(updatedCategory.getDescription());

            return ResponseEntity.ok(category);
        } else return ResponseEntity.notFound().build();
    }
}
