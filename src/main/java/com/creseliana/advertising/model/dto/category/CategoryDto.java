package com.creseliana.advertising.model.dto.category;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Valeria Sterzhanova
 */
@Getter
@Setter
@Schema(description = "Категория объявления")
public class CategoryDto {

    @Schema(description = "Идентификатор", required = true)
    private Long id;

    @NotBlank(message = "Category name must contain at least one character")
    @Schema(description = "Наименование", required = true)
    private String name;
}
