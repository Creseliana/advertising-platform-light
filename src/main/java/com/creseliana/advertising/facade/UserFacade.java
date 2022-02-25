package com.creseliana.advertising.facade;

import com.creseliana.advertising.model.dto.user.UserBaseResponse;
import com.creseliana.advertising.model.dto.user.UserCreateRequest;
import com.creseliana.advertising.model.dto.user.UserEditRequest;
import java.util.List;

/**
 * @author Valeria Sterzhanova
 */
public interface UserFacade {

    UserBaseResponse create(UserCreateRequest userRequest);

    UserBaseResponse edit(UserEditRequest userRequest, String username);

    UserBaseResponse getByUsername(String username);

    UserBaseResponse getById(Long id);

    List<UserBaseResponse> getAll();

    UserBaseResponse blockById(Long id);
}
