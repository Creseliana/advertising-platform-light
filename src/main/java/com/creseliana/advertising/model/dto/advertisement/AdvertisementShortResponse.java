package com.creseliana.advertising.model.dto.advertisement;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Valeria Sterzhanova
 */
@Getter
@Setter
@Schema(description = "Объявление (кратко)")
public class AdvertisementShortResponse {

    @Schema(description = "Идентификатор")
    private Long id;

    @Schema(description = "Ник автора")
    private String authorUsername;

    @Schema(description = "Заголовок")
    private String title;

    @Schema(description = "Цена")
    private BigDecimal price;

    @Schema(description = "Код валюты")
    private String currencyCode;

    @Schema(description = "Дата создания")
    private LocalDateTime creationDate;
}
