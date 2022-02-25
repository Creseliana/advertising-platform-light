package com.creseliana.advertising.facade.impl;

import com.creseliana.advertising.facade.UserFacade;
import com.creseliana.advertising.model.domain.User;
import com.creseliana.advertising.model.dto.user.UserBaseResponse;
import com.creseliana.advertising.model.dto.user.UserCreateRequest;
import com.creseliana.advertising.model.dto.user.UserEditRequest;
import com.creseliana.advertising.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * @author Valeria Sterzhanova
 */
@Component
@RequiredArgsConstructor
public class UserFacadeImpl extends AbstractFacade implements UserFacade {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @Override
    public UserBaseResponse create(UserCreateRequest userRequest) {
        User user = modelMapper.map(userRequest, User.class);
        return modelMapper.map(userService.save(user), UserBaseResponse.class);
    }

    @Override
    public UserBaseResponse edit(UserEditRequest userRequest, String username) {
        User user = modelMapper.map(userRequest, User.class);
        return modelMapper.map(userService.update(user, username), UserBaseResponse.class);
    }

    @Override
    public UserBaseResponse getByUsername(String username) {
        return modelMapper.map(userService.loadUserByUsername(username), UserBaseResponse.class);
    }

    @Override
    public UserBaseResponse getById(Long id) {
        return modelMapper.map(userService.findById(id), UserBaseResponse.class);
    }

    @Override
    public List<UserBaseResponse> getAll() {
        return mapEntityList(modelMapper, userService.findAll(), UserBaseResponse.class);
    }

    @Override
    public UserBaseResponse blockById(Long id) {
        return modelMapper.map(userService.block(id), UserBaseResponse.class);
    }
}
