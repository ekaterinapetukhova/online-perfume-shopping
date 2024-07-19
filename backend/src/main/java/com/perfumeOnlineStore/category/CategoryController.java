package com.perfumeOnlineStore.category;

import com.perfumeOnlineStore.product.Product;
import com.perfumeOnlineStore.product.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.rmi.ServerException;
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

        return ResponseEntity.ok(categories);
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
    public ResponseEntity<Category> createProduct(@RequestBody Category newCategory,
                                                 HttpServletRequest request) throws ServerException {
        Category category = categoryService.saveCategory(newCategory);

        if (category != null) {
            URI location = ServletUriComponentsBuilder.fromRequestUri(request)
                    .path("/{categoryId}")
                    .buildAndExpand(category.getId())
                    .toUri();
            return ResponseEntity.created(location).body(category);
        } else throw new ServerException("Error in creating the Category resource. Try Again.");
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
