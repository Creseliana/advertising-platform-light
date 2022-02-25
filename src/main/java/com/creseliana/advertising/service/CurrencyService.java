package com.creseliana.advertising.service;

import com.creseliana.advertising.model.domain.Currency;

/**
 * @author Valeria Sterzhanova
 */
public interface CurrencyService extends EntityService<Currency> {

    Currency findByCode(String code);
}
