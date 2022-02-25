package com.creseliana.advertising.service;

import com.creseliana.advertising.model.domain.Advertisement;
import java.util.List;

/**
 * @author Valeria Sterzhanova
 */
public interface AdvertisementService extends EntityService<Advertisement> {

    Advertisement update(Advertisement ad, String username);

    List<Advertisement> findAllActive();

    List<Advertisement> findAllActiveByCategoryName(String name);

    List<Advertisement> findAllByUsername(String username, boolean closed);

    Advertisement closeById(Long id);

    Advertisement deleteById(Long id);
}
