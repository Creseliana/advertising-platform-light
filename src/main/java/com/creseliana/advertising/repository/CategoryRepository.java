package com.creseliana.advertising.repository;

import com.creseliana.advertising.model.domain.Category;
import java.util.Optional;
import org.springframework.stereotype.Repository;

/**
 * @author Valeria Sterzhanova
 */
@Repository
public interface CategoryRepository extends EntityRepository<Category> {

    Optional<Category> findByName(String name);
}
