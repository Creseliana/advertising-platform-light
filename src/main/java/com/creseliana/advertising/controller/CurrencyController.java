package com.creseliana.advertising.controller;

import com.creseliana.advertising.facade.CurrencyFacade;
import com.creseliana.advertising.model.dto.currency.CurrencyDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Valeria Sterzhanova
 */
@RestController
@RequestMapping(path = "currencies", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name = "currencies", description = "Управление валютами")
public class CurrencyController {

    private final CurrencyFacade currencyFacade;

    @PostMapping
    @Operation(operationId = "create-currency", summary = "Создание валюты")
    public CurrencyDto create(@Valid @RequestBody CurrencyDto currency) {
        return currencyFacade.create(currency);
    }

    @GetMapping("{id}")
    @Operation(operationId = "get-currency-by-id", summary = "Получение валюты по идентификатору")
    public CurrencyDto getById(@PathVariable Long id) {
        return currencyFacade.getById(id);
    }

    @GetMapping("/code/{code}")
    @Operation(operationId = "get-currency-by-code", summary = "Получение валюты по коду")
    public CurrencyDto getByCode(@PathVariable String code) {
        return currencyFacade.getByCode(code);
    }

    @GetMapping
    @Operation(operationId = "get-all-currencies", summary = "Получение всех валют")
    public List<CurrencyDto> getAll() {
        return currencyFacade.getAll();
    }
}
