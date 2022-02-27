package com.creseliana.advertising.facade.impl;

import com.creseliana.advertising.facade.CurrencyFacade;
import com.creseliana.advertising.model.domain.Currency;
import com.creseliana.advertising.model.dto.currency.CurrencyDto;
import com.creseliana.advertising.service.CurrencyService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * @author Valeria Sterzhanova
 */
@Component
@RequiredArgsConstructor
public class CurrencyFacadeImpl extends AbstractFacade implements CurrencyFacade {

    private final CurrencyService currencyService;
    private final ModelMapper modelMapper;

    @Override
    public CurrencyDto create(CurrencyDto currencyRequest) {
        Currency currency = modelMapper.map(currencyRequest, Currency.class);
        return modelMapper.map(currencyService.save(currency), CurrencyDto.class);
    }

    @Override
    public CurrencyDto getById(Long id) {
        return modelMapper.map(currencyService.findById(id), CurrencyDto.class);
    }

    @Override
    public CurrencyDto getByCode(String code) {
        return modelMapper.map(currencyService.findByCode(code), CurrencyDto.class);
    }

    @Override
    public List<CurrencyDto> getAll() {
        return mapEntityList(modelMapper, currencyService.findAll(), CurrencyDto.class);
    }
}
