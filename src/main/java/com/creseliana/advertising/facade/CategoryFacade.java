package com.creseliana.advertising.facade;

import com.creseliana.advertising.model.dto.category.CategoryDto;
import java.util.List;

/**
 * @author Valeria Sterzhanova
 */
public interface CategoryFacade {

    CategoryDto create(CategoryDto categoryRequest);

    CategoryDto getById(Long id);

    CategoryDto getByName(String name);

    List<CategoryDto> getAll();
}
