package com.creseliana.advertising.controller;

import com.creseliana.advertising.facade.UserFacade;
import com.creseliana.advertising.model.dto.user.UserBaseResponse;
import com.creseliana.advertising.model.dto.user.UserCreateRequest;
import com.creseliana.advertising.model.dto.user.UserEditRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Valeria Sterzhanova
 */
@RestController
@RequestMapping(path = "users", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name = "users", description = "Управление пользователями")
public class UserController {

    private final UserFacade userFacade;

    @PostMapping
    @Operation(operationId = "create-user", summary = "Создание пользователя")
    public UserBaseResponse create(@Valid @RequestBody UserCreateRequest user) {
        return userFacade.create(user);
    }

    @PutMapping
    @Operation(operationId = "edit-user", summary = "Редактирование данных пользователя")
    public UserBaseResponse edit(@Valid @RequestBody UserEditRequest user,
        Authentication authentication) {
        return userFacade.edit(user, authentication.getUsername());
    }

    @GetMapping("username/{username}")
    @Operation(operationId = "get-user-by-username", summary = "Получение пользователя по нику")
    public UserBaseResponse getByUsername(@PathVariable String username) {
        return userFacade.getByUsername(username);
    }

    @GetMapping("{id}")
    @Operation(operationId = "get-user-by-id", summary = "Получение пользователя по идентификатору")
    public UserBaseResponse getById(@PathVariable Long id) {
        return userFacade.getById(id);
    }

    @GetMapping
    @Operation(operationId = "get-all-users", summary = "Получение всех пользователей")
    public List<UserBaseResponse> getAll() {
        return userFacade.getAll();
    }

    @DeleteMapping("{id}")
    @Operation(operationId = "block-user-by-id",
        summary = "Удаление пользователя по идентификатору")
    public UserBaseResponse blockById(@PathVariable Long id) {
        return userFacade.blockById(id);
    }
}
