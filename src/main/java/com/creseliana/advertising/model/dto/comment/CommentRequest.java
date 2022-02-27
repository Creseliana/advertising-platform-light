package com.creseliana.advertising.model.dto.comment;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Valeria Sterzhanova
 */
@Getter
@Setter
@Schema(description = "Создание комментария")
public class CommentRequest {

    @NotBlank(message = "Comment must contain at least one character")
    @Schema(description = "Текст комментария", required = true)
    private String comment;
}
