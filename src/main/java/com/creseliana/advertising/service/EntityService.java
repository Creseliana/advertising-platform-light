package com.creseliana.advertising.service;

import com.creseliana.advertising.model.domain.AbstractEntity;
import java.util.List;

/**
 * @author Valeria Sterzhanova
 */
public interface EntityService<E extends AbstractEntity> {

    E save(E entity);

    E update(E entity);

    E findById(Long id);

    List<E> findAll();
}
