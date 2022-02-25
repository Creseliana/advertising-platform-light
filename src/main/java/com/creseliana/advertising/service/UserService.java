package com.creseliana.advertising.service;

import com.creseliana.advertising.model.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author Valeria Sterzhanova
 */
public interface UserService extends EntityService<User>, UserDetailsService {

    User update(User user, String username);

    User block(Long id);
}
