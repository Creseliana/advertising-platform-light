package com.creseliana.advertising.facade.impl;

import com.creseliana.advertising.facade.AdvertisementFacade;
import com.creseliana.advertising.model.domain.Advertisement;
import com.creseliana.advertising.model.dto.advertisement.AdvertisementBaseResponse;
import com.creseliana.advertising.model.dto.advertisement.AdvertisementCreateRequest;
import com.creseliana.advertising.model.dto.advertisement.AdvertisementEditRequest;
import com.creseliana.advertising.model.dto.advertisement.AdvertisementShortResponse;
import com.creseliana.advertising.service.AdvertisementService;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * @author Valeria Sterzhanova
 */
@Component
@RequiredArgsConstructor
public class AdvertisementFacadeImpl extends AbstractFacade implements AdvertisementFacade {

    private final AdvertisementService advertisementService;
    private final ModelMapper modelMapper;

    @PostConstruct
    public void init() {
        modelMapper.createTypeMap(AdvertisementCreateRequest.class, Advertisement.class)
            .addMappings(mapper -> mapper.skip(Advertisement::setId));
    }

    @Override
    public AdvertisementBaseResponse create(AdvertisementCreateRequest advertisementRequest) {
        Advertisement ad = modelMapper.map(advertisementRequest, Advertisement.class);
        return modelMapper.map(advertisementService.save(ad), AdvertisementBaseResponse.class);
    }

    @Override
    public AdvertisementBaseResponse edit(AdvertisementEditRequest advertisementRequest,
        String username) {
        Advertisement ad = modelMapper.map(advertisementRequest, Advertisement.class);
        return modelMapper.map(advertisementService.update(ad, username),
            AdvertisementBaseResponse.class);
    }

    @Override
    public AdvertisementBaseResponse getById(Long id) {
        return modelMapper.map(advertisementService.findById(id), AdvertisementBaseResponse.class);
    }

    @Override
    public List<AdvertisementShortResponse> getAllActive() {
        return mapEntityList(modelMapper, advertisementService.findAllActive(),
            AdvertisementShortResponse.class);
    }

    @Override
    public List<AdvertisementShortResponse> getAllActiveByCategoryName(String name) {
        return mapEntityList(modelMapper, advertisementService.findAllActiveByCategoryName(name),
            AdvertisementShortResponse.class);
    }

    @Override
    public List<AdvertisementShortResponse> getAllByUsername(String username, boolean closed) {
        return mapEntityList(modelMapper, advertisementService.findAllByUsername(username, closed),
            AdvertisementShortResponse.class);
    }

    @Override
    public AdvertisementBaseResponse closeById(Long id) {
        return modelMapper.map(advertisementService.closeById(id),
            AdvertisementBaseResponse.class);
    }

    @Override
    public AdvertisementBaseResponse deleteById(Long id) {
        return modelMapper.map(advertisementService.deleteById(id),
            AdvertisementBaseResponse.class);
    }
}
