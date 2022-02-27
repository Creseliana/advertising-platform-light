package com.creseliana.advertising.repository;

import com.creseliana.advertising.model.domain.Currency;
import java.util.Optional;
import org.springframework.stereotype.Repository;

/**
 * @author Valeria Sterzhanova
 */
@Repository
public interface CurrencyRepository extends EntityRepository<Currency> {

    Optional<Currency> getByCode(String code);
}
