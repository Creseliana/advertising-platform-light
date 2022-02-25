package com.creseliana.advertising.model.dto.category;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Valeria Sterzhanova
 */
@Getter
@Setter
@Schema(description = "Категория объявления")
public class CategoryDto {

    @NotNull(message = "Category id must not be null")
    @Schema(description = "Идентификатор категории", required = true)
    private Long id;

    @NotBlank(message = "Category name must contain at least one character")
    @Schema(description = "Наименование категории", required = true)
    private String name;
}
