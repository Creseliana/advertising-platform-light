package com.creseliana.advertising.model.dto.advertisement;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Valeria Sterzhanova
 */
@Getter
@Setter
@Schema(description = "Редактирование объявления")
public class AdvertisementEditRequest {

    @NotNull(message = "Advertisement category id must not be null")
    @Schema(description = "Идентификатор категории", required = true)
    private Long categoryId;

    @NotBlank(message = "Advertisement title must contain at least one character")
    @Schema(description = "Заголовок объявления", required = true)
    private String title;

    @Schema(description = "Описание")
    private String description;

    @NotNull(message = "Advertisement price must not be null")
    @Positive(message = "Advertisement price must be positive number")
    @Digits(integer = 14, fraction = 2,
        message = "Advertisement price cannot contain more than 14 integer and 2 fractional digits")
    @Schema(description = "Цена", required = true)
    private BigDecimal price;

    @NotNull(message = "Advertisement currency id must not be null")
    @Schema(description = "Идентификатор валюты", required = true)
    private Long currencyId;
}
