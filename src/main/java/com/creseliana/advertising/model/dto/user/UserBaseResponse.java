package com.creseliana.advertising.model.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Valeria Sterzhanova
 */
@Getter
@Setter
@Schema(description = "Аккаунт пользователя")
public class UserBaseResponse {

    @Schema(description = "Ник")
    private String username;

    @Schema(description = "Имя")
    private String firstName;

    @Schema(description = "Фамилия")
    private String lastName;

    @Schema(description = "Электронная почта")
    private String email;

    @Schema(description = "Номер телефона")
    private String phoneNumber;

    @Schema(description = "Признак активности аккаунта")
    private Boolean active;

    @Schema(description = "Дата регистрации")
    private LocalDateTime registrationDate;
}
