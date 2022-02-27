package com.creseliana.advertising.service.impl;

import com.creseliana.advertising.exception.AccessDeniedException;
import com.creseliana.advertising.exception.EntityNotFoundException;
import com.creseliana.advertising.model.domain.Role;
import com.creseliana.advertising.model.domain.User;
import com.creseliana.advertising.model.domain.type.RoleType;
import com.creseliana.advertising.repository.UserRepository;
import com.creseliana.advertising.service.UserService;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Valeria Sterzhanova
 */
@Service
@Transactional
public class UserServiceImpl extends
    AbstractService<User, UserRepository> implements UserService {

    private static final String MSG_USER_EDIT_FORBIDDEN =
        "User profile cannot be edited by other user";

    private final PasswordEncoder passwordEncoder;

    private final Role userRole = new Role();

    public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder) {
        super(repository);
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    private void getRoles() {
        userRole.setId(1L);
        userRole.setType(RoleType.USER);
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username);
    }

    @Override
    public User save(User entity) {
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        entity.setActive(true);
        entity.setRoleSet(Set.of(userRole));
        return super.save(entity);
    }

    @Override
    public User update(User user, String username) {
        User editUser = this.findById(user.getId());
        if (!editUser.getUsername().equals(username)) {
            throw new AccessDeniedException(MSG_USER_EDIT_FORBIDDEN);
        }
        editUser.setFirstName(user.getFirstName());
        editUser.setLastName(user.getLastName());
        editUser.setEmail(user.getEmail());
        editUser.setPhoneNumber(user.getPhoneNumber());
        return repository.save(editUser);
    }

    @Override
    public User block(Long id) {
        User user = repository.findById(id).orElseThrow(() -> {
            String msg = String
                .format(MSG_ENTITY_NOT_FOUND, getEntityClass().getSimpleName(), "id", id);
            throw new EntityNotFoundException(msg);
        });
        user.setActive(false);
        return repository.save(user);
    }
}
