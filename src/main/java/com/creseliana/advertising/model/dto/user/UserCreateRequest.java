package com.creseliana.advertising.model.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Valeria Sterzhanova
 */
@Getter
@Setter
@Schema(description = "Создание аккаунта пользователя")
public class UserCreateRequest {

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9-_]*$")
    @Schema(description = "Ник", required = true)
    private String username;

    @NotBlank
    @Schema(description = "Пароль", required = true)
    private String password;

    @NotBlank
    @Schema(description = "Имя", required = true)
    private String firstName;

    @NotBlank
    @Schema(description = "Фамилия", required = true)
    private String lastName;

    @NotBlank
    @Email
    @Schema(description = "Электронная почта", required = true)
    private String email;

    @NotBlank
    @Pattern(regexp = "^[0-9]{7,15}$")
    @Schema(description = "Номер телефона", required = true)
    private String phoneNumber;
}
