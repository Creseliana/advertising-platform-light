package com.creseliana.advertising.service;

import com.creseliana.advertising.model.domain.Category;

/**
 * @author Valeria Sterzhanova
 */
public interface CategoryService extends EntityService<Category> {

    Category findByName(String name);
}
