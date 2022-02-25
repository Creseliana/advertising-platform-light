package com.creseliana.advertising.facade;

import com.creseliana.advertising.model.dto.currency.CurrencyDto;
import java.util.List;

/**
 * @author Valeria Sterzhanova
 */
public interface CurrencyFacade {

    CurrencyDto create(CurrencyDto currencyRequest);

    CurrencyDto getById(Long id);

    CurrencyDto getByCode(String code);

    List<CurrencyDto> getAll();
}
