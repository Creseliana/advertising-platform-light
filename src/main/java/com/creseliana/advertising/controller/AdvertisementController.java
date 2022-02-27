package com.creseliana.advertising.controller;

import com.creseliana.advertising.facade.AdvertisementFacade;
import com.creseliana.advertising.model.dto.advertisement.AdvertisementBaseResponse;
import com.creseliana.advertising.model.dto.advertisement.AdvertisementCreateRequest;
import com.creseliana.advertising.model.dto.advertisement.AdvertisementEditRequest;
import com.creseliana.advertising.model.dto.advertisement.AdvertisementShortResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Valeria Sterzhanova
 */
@RestController
@RequestMapping(path = "advertisements", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name = "advertisements", description = "Управление объявлениями")
public class AdvertisementController {

    private final AdvertisementFacade advertisementFacade;

    @PostMapping
    @Operation(operationId = "create-ad", summary = "Создание объявления")
    public AdvertisementBaseResponse create(@Valid @RequestBody AdvertisementCreateRequest ad) {
        return advertisementFacade.create(ad);
    }

    @PutMapping
    @Operation(operationId = "edit-ad", summary = "Редактирование объявления")
    public AdvertisementBaseResponse edit(@Valid @RequestBody AdvertisementEditRequest ad,
        Authentication authentication) {
        return advertisementFacade.edit(ad, authentication.getName());
    }

    @GetMapping("search/{id}")
    @Operation(operationId = "get-ad-by-id", summary = "Получение объявления по идентификатору")
    public AdvertisementBaseResponse getById(@PathVariable Long id) {
        return advertisementFacade.getById(id);
    }

    @GetMapping("search")
    @Operation(operationId = "get-all-active-ads", summary = "Получение всех актуальных объявлений")
    public List<AdvertisementShortResponse> getAllActive() {
        return advertisementFacade.getAllActive();
    }

    @GetMapping("search/categories/{name}")
    @Operation(operationId = "get-all-active-ads-by-category",
        summary = "Получение всех актуальных объявлений по категории")
    public List<AdvertisementShortResponse> getAllActiveByCategoryName(
        @PathVariable String name) {
        return advertisementFacade.getAllActiveByCategoryName(name);
    }

    @GetMapping("search/users/{username}")
    @Operation(operationId = "get-all-ads-by-username",
        summary = "Получение всех объявлений пользователя")
    public List<AdvertisementShortResponse> getAllByUsername(@PathVariable String username,
        @RequestParam boolean closed) {
        return advertisementFacade.getAllByUsername(username, closed);
    }

    @PatchMapping("{id}")
    @Operation(operationId = "close-ad", summary = "Закрытие объявления")
    public AdvertisementBaseResponse close(@PathVariable Long id) {
        return advertisementFacade.closeById(id);
    }

    @DeleteMapping("{id}")
    @Operation(operationId = "delete-ad", summary = "Удаление объявления")
    public AdvertisementBaseResponse delete(@PathVariable Long id) {
        return advertisementFacade.deleteById(id);
    }
}
