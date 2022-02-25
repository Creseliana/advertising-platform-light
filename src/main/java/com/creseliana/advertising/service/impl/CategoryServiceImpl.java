package com.creseliana.advertising.service.impl;

import com.creseliana.advertising.exception.EntityNotFoundException;
import com.creseliana.advertising.model.domain.Category;
import com.creseliana.advertising.repository.CategoryRepository;
import com.creseliana.advertising.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Valeria Sterzhanova
 */
@Service
@Transactional
public class CategoryServiceImpl extends
    AbstractService<Category, CategoryRepository> implements CategoryService {

    public CategoryServiceImpl(CategoryRepository repository) {
        super(repository);
    }

    @Override
    protected Class<Category> getEntityClass() {
        return Category.class;
    }

    @Override
    public Category findByName(String name) {
        return repository.findByName(name).orElseThrow(() -> {
            String msg = String
                .format(MSG_ENTITY_NOT_FOUND, getEntityClass().getSimpleName(), "name", name);
            throw new EntityNotFoundException(msg);
        });
    }
}
