package com.creseliana.advertising.model.dto.comment;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Valeria Sterzhanova
 */
@Getter
@Setter
@Schema(description = "Комментарий")
public class CommentResponse {

    @Schema(description = "Ник пользователя")
    private String authorUsername;

    @Schema(description = "Дата создания")
    private LocalDateTime creationDate;

    @Schema(description = "Текст комментария")
    private String comment;
}
