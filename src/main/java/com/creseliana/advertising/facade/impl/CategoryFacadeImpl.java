package com.creseliana.advertising.facade.impl;

import com.creseliana.advertising.facade.CategoryFacade;
import com.creseliana.advertising.model.domain.Category;
import com.creseliana.advertising.model.dto.category.CategoryDto;
import com.creseliana.advertising.service.CategoryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * @author Valeria Sterzhanova
 */
@Component
@RequiredArgsConstructor
public class CategoryFacadeImpl extends AbstractFacade implements CategoryFacade {

    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    @Override
    public CategoryDto create(CategoryDto categoryRequest) {
        Category category = modelMapper.map(categoryRequest, Category.class);
        return modelMapper.map(categoryService.save(category), CategoryDto.class);
    }

    @Override
    public CategoryDto getById(Long id) {
        return modelMapper.map(categoryService.findById(id), CategoryDto.class);
    }

    @Override
    public CategoryDto getByName(String name) {
        return modelMapper.map(categoryService.findByName(name), CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAll() {
        return mapEntityList(modelMapper, categoryService.findAll(), CategoryDto.class);
    }
}
