package com.creseliana.advertising.facade;

import com.creseliana.advertising.model.dto.advertisement.AdvertisementBaseResponse;
import com.creseliana.advertising.model.dto.advertisement.AdvertisementCreateRequest;
import com.creseliana.advertising.model.dto.advertisement.AdvertisementEditRequest;
import com.creseliana.advertising.model.dto.advertisement.AdvertisementShortResponse;
import java.util.List;

/**
 * @author Valeria Sterzhanova
 */
public interface AdvertisementFacade {

    AdvertisementBaseResponse create(AdvertisementCreateRequest advertisementRequest);

    AdvertisementBaseResponse edit(AdvertisementEditRequest advertisementRequest, String username);

    AdvertisementBaseResponse getById(Long id);

    List<AdvertisementShortResponse> getAllActive();

    List<AdvertisementShortResponse> getAllActiveByCategoryName(String name);

    List<AdvertisementShortResponse> getAllByUsername(String username, boolean closed);

    AdvertisementBaseResponse closeById(Long id);

    AdvertisementBaseResponse deleteById(Long id);
}
