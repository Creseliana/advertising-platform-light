package com.creseliana.advertising.service.impl;

import com.creseliana.advertising.exception.EntityNotFoundException;
import com.creseliana.advertising.model.domain.Currency;
import com.creseliana.advertising.repository.CurrencyRepository;
import com.creseliana.advertising.service.CurrencyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Valeria Sterzhanova
 */
@Service
@Transactional
public class CurrencyServiceImpl extends
    AbstractService<Currency, CurrencyRepository> implements CurrencyService {

    public CurrencyServiceImpl(CurrencyRepository repository) {
        super(repository);
    }

    @Override
    protected Class<Currency> getEntityClass() {
        return Currency.class;
    }

    @Override
    public Currency findByCode(String code) {
        return repository.getByCode(code).orElseThrow(() -> {
            String msg = String.format(MSG_ENTITY_NOT_FOUND,
                getEntityClass().getSimpleName(), "code", code);
            throw new EntityNotFoundException(msg);
        });
    }
}
