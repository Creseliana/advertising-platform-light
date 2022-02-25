package com.creseliana.advertising.model.dto.currency;

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
@Schema(description = "Валюта")
public class CurrencyDto {

    @Schema(description = "Идентификатор валюты")
    private Long id;

    @NotBlank(message = "Currency code must contain at least one character")
    @Schema(description = "Код валюты", required = true)
    private String code;

    @NotNull
    @Positive
    @Digits(integer = 14, fraction = 2,
        message = "Currency quantum cannot contain more than 14 integer and 2 fractional digits")
    @Schema(description = "Минимальная единица валюты", required = true)
    private BigDecimal quantum;
}
