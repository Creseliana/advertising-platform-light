package com.creseliana.advertising.repository;

import com.creseliana.advertising.model.domain.User;
import org.springframework.stereotype.Repository;

/**
 * @author Valeria Sterzhanova
 */
@Repository
public interface UserRepository extends EntityRepository<User> {

    User findByUsername(String username);
}
