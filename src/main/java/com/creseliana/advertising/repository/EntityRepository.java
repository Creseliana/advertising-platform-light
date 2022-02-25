package com.creseliana.advertising.repository;

import com.creseliana.advertising.model.domain.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Valeria Sterzhanova
 */
public interface EntityRepository<E extends AbstractEntity> extends JpaRepository<E, Long> {

}
