package com.creseliana.advertising.service.impl;

import com.creseliana.advertising.exception.EntityNotFoundException;
import com.creseliana.advertising.model.domain.AbstractEntity;
import com.creseliana.advertising.repository.EntityRepository;
import com.creseliana.advertising.service.EntityService;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Valeria Sterzhanova
 */
@Transactional
public abstract class AbstractService<
    E extends AbstractEntity,
    R extends EntityRepository<E>>
    implements EntityService<E> {

    protected static final String MSG_ENTITY_NOT_FOUND = "%s with %s %s not found";

    protected final R repository;

    public AbstractService(R repository) {
        this.repository = repository;
    }

    @Override
    public E save(E entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public E update(E entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public E findById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> {
                String msg = String.format(MSG_ENTITY_NOT_FOUND,
                    getEntityClass().getSimpleName(), "id", id);
                throw new EntityNotFoundException(msg);
            });
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    protected abstract Class<E> getEntityClass();
}
