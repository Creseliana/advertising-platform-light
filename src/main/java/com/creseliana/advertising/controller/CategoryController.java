package com.creseliana.advertising.controller;

import com.creseliana.advertising.facade.CategoryFacade;
import com.creseliana.advertising.model.dto.category.CategoryDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Valeria Sterzhanova
 */
@RestController
@RequestMapping(path = "categories", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name = "categories", description = "Управление категориями")
public class CategoryController {

    private final CategoryFacade categoryFacade;

    @PostMapping
    @Operation(operationId = "create-category", summary = "Создание категории")
    public CategoryDto create(@Valid @RequestBody CategoryDto category) {
        return categoryFacade.create(category);
    }

    @GetMapping("{id}")
    @Operation(operationId = "get-category-by-id",
        summary = "Получение категории по идентификатору")
    public CategoryDto getById(@PathVariable Long id) {
        return categoryFacade.getById(id);
    }

    @GetMapping("code/{name}")
    @Operation(operationId = "get-category-by-name",
        summary = "Получение категории по наименованию")
    public CategoryDto getByName(@PathVariable String name) {
        return categoryFacade.getByName(name);
    }

    @GetMapping
    @Operation(operationId = "get-all-categories", summary = "Получение всех категорий")
    public List<CategoryDto> getAll() {
        return categoryFacade.getAll();
    }
}
